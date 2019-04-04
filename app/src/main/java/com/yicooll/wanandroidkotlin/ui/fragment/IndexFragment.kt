package com.yicooll.wanandroidkotlin.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.bigkoo.convenientbanner.ConvenientBanner
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator
import com.bigkoo.convenientbanner.holder.Holder
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.yicooll.wanandroidkotlin.Constant
import com.yicooll.wanandroidkotlin.base.BaseFragment
import com.yicooll.wanandroidkotlin.entity.ModelIndexArtical
import com.yicooll.wanandroidkotlin.entity.ModelIndexBanner
import com.yicooll.wanandroidkotlin.entity.Template
import com.yicooll.wanandroidkotlin.ui.adapter.IndexArticalAdapter
import com.yicooll.wanandroidkotlin.ui.adapter.IndexBlockAdapter
import com.yicooll.wanandroidkotlin.viewModel.IndexViewModel
import kotlinx.android.synthetic.main.fragment_index.*
import android.R
import android.os.Handler
import android.os.Message


/**
 * A simple [Fragment] subclass.
 *
 */
class IndexFragment : BaseFragment() {

    private var vm: IndexViewModel? = null
    private var mImageLoadHoder: BannerHolder? = null
    private var bannerList = ArrayList<ModelIndexBanner.DataBean>()
    private val templateList = ArrayList<Template>()
    private val articalList = ArrayList<ModelIndexArtical.DataBean.DatasBean>()
    private val LOADERMORE: Int = 1000
    private val LOADERMORE_DELAYER: Long = 800
    private var pageNum = 1
    private var articalAdapter: IndexArticalAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.yicooll.wanandroidkotlin.R.layout.fragment_index, container, false)
    }

    override fun initViewAndEvent() {
        vm = ViewModelProviders.of(this).get(IndexViewModel::class.java)
        vm?.getBannerLiveData()?.observe(this, Observer {

            bannerList.clear()
            if (it != null) {
                bannerList.addAll(it.data)
            }
            cb_banner.notifyDataSetChanged()


        })

        vm?.getArticalLiveData()?.observe(this, Observer {
            if (pageNum == 1) {
                articalList.clear()
            }
            it?.let { it1 ->
                articalList.addAll(it1.data.datas)
            }
            // articalAdapter?.notifyDataSetChanged()

            rv_list.postDelayed({
                if (articalList.size < 20) {
                    articalAdapter?.loadMoreEnd()
                } else {
                    articalAdapter?.addData(articalList)
                    articalAdapter?.loadMoreComplete()
                }
            }, LOADERMORE_DELAYER)


        })

        cb_banner.setPages(CBViewHolderCreator<BannerHolder> {
            if (mImageLoadHoder == null) {
                mImageLoadHoder = BannerHolder()
            }
            return@CBViewHolderCreator mImageLoadHoder
        }, bannerList as List<Nothing>).setPageIndicator(intArrayOf(com.yicooll.wanandroidkotlin.R.mipmap.ic_indicator_normal, com.yicooll.wanandroidkotlin.R.mipmap.ic_indicator_selected))
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .startTurning(Constant.BANNER_TURN)

        rv_block.adapter = IndexBlockAdapter(activity!!.applicationContext, getIndexFuntionBlock())
        rv_block.layoutManager = GridLayoutManager(activity, 4, GridLayoutManager.VERTICAL, false)

        articalAdapter = IndexArticalAdapter(com.yicooll.wanandroidkotlin.R.layout.wan_item_of_article_list, articalList)
        rv_list.adapter = articalAdapter
        rv_list.layoutManager = LinearLayoutManager(activity)
        articalAdapter?.setOnLoadMoreListener({
            // mHandler.sendEmptyMessageDelayed(LOADERMORE, LOADERMORE_DELAYER)
            vm?.getIndexArtical(++pageNum)
        }, rv_list)

        //articalAdapter?.disableLoadMoreIfNotFullPage()


    }

    private var mHandler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (msg.what == LOADERMORE) {
                vm?.getIndexArtical(++pageNum)
            }
        }
    }


    inner class BannerHolder : Holder<ModelIndexBanner.DataBean> {

        private var imageView: ImageView? = null
        override fun UpdateUI(context: Context?, position: Int, data: ModelIndexBanner.DataBean?) {
            Glide.with(context!!).load(data!!.imagePath).into(imageView!!)
        }

        override fun createView(context: Context?): View? {
            imageView = ImageView(context)
            imageView!!.scaleType = ImageView.ScaleType.CENTER_CROP
            return imageView
        }

    }


    fun getIndexFuntionBlock(): List<Template> {
        templateList.clear()
        templateList.add(Template(com.yicooll.wanandroidkotlin.R.mipmap.wan_icon_1, "体系"))
        templateList.add(Template(com.yicooll.wanandroidkotlin.R.mipmap.wan_icon_2, "项目"))
        templateList.add(Template(com.yicooll.wanandroidkotlin.R.mipmap.wan_icon_3, "公众号"))
        templateList.add(Template(com.yicooll.wanandroidkotlin.R.mipmap.wan_icon_4, "搜索"))
        return templateList
    }

}
