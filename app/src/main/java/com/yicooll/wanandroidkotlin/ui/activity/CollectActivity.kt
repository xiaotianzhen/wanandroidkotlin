package com.yicooll.wanandroidkotlin.ui.activity


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.yicooll.wanandroidkotlin.Constant
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseActivity
import com.yicooll.wanandroidkotlin.entity.ModelCollect
import com.yicooll.wanandroidkotlin.ui.adapter.CollectAdapter
import com.yicooll.wanandroidkotlin.utils.ToActivityHelper
import com.yicooll.wanandroidkotlin.viewModel.CollectViewModel
import kotlinx.android.synthetic.main.activity_collect.*
import kotlinx.android.synthetic.main.include_noback_toolbar.*

class CollectActivity : BaseActivity() {
    private var adapter: CollectAdapter? = null
    private var collectData = ArrayList<ModelCollect.Data.Data>()
    private var vm: CollectViewModel? = null
    private var pageNum = 0

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_collect
    }

    override fun initView() {

        var llMenu = getHeadMenu()
        layoutInflater.inflate(R.layout.include_base_toolbar, llMenu)
        tv_menu_center.text = "项目"

        adapter = CollectAdapter(R.layout.adapter_project_list, collectData)
        rv_collect.adapter = adapter
        rv_collect.layoutManager = LinearLayoutManager(this)

    }

    override fun initEvent() {
        vm = ViewModelProviders.of(this).get(CollectViewModel::class.java)
        vm?.getCollectList(pageNum)
        vm?.getCollectLiveData()?.observe(this, Observer {
            if (pageNum == 0)
                collectData.clear()
            it?.let { it1 ->
                if(it1.errorCode==0){
                    if (it1.data?.datas != null) {
                        collectData.addAll(it1.data.datas)

                        if (it1.data.datas.size < Constant.ONE_PAGE_COUNT) {
                            adapter?.loadMoreEnd()
                        } else {
                            adapter?.loadMoreComplete()
                        }
                    }
                }else{
                    showToast(it1.errorMsg)
                }
            }
            if(it==null){
                showToast(Constant.NETWORK_ERROR)
            }
        })

        adapter?.setOnLoadMoreListener({
            vm?.getCollectList(++pageNum)
        }, rv_collect)

        adapter?.setOnItemClickListener { adapter, view, position ->

            val bundle= Bundle()
            bundle.putString("url", collectData[position].link)
            bundle.putString("title", collectData[position].title)
            ToActivityHelper.getInstance()?.toActivity(this,MainWebActivity::class.java,bundle)

        }
    }
}
