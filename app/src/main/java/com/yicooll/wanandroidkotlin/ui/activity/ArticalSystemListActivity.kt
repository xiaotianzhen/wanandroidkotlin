package com.yicooll.wanandroidkotlin.ui.activity

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.yicooll.wanandroidkotlin.Constant
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseActivity
import com.yicooll.wanandroidkotlin.entity.ModelArticalSystemList
import com.yicooll.wanandroidkotlin.ui.adapter.ArticalSystemListAdapter
import com.yicooll.wanandroidkotlin.utils.ToActivityHelper
import com.yicooll.wanandroidkotlin.viewModel.ArticalSystemListViewModel
import kotlinx.android.synthetic.main.activity_artical_system_list.*
import kotlinx.android.synthetic.main.include_noback_toolbar.*

class ArticalSystemListActivity : BaseActivity() {


    private var adapter: ArticalSystemListAdapter? = null
    private val articalList = ArrayList<ModelArticalSystemList.Data.Data>()
    private var vm: ArticalSystemListViewModel? = null
    private var pageNum=0

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_artical_system_list
    }

    override fun initView() {
        var llMenu = getHeadMenu()
        layoutInflater.inflate(R.layout.include_base_toolbar, llMenu)
        if(intent!=null)
        tv_menu_center.text = intent.getStringExtra("title")

        adapter = ArticalSystemListAdapter(R.layout.wan_item_of_article_list, articalList)
        rv_artical_system.adapter = adapter
        rv_artical_system.layoutManager = LinearLayoutManager(this)


    }

    override fun initEvent() {
        vm = ViewModelProviders.of(this).get(ArticalSystemListViewModel::class.java)
        if(intent!=null)
        vm?.initRequest(intent.getIntExtra("cid",0),pageNum)

        vm?.getArticalSystemListLiveData()?.observe(this, Observer {

            if(pageNum==1){
                articalList.clear()
            }
            it?.let { it1 ->
                articalList.addAll(it1.data.datas)
                adapter?.notifyDataSetChanged()
                if(it1.data.datas.size <Constant.ONE_PAGE_COUNT){
                    adapter?.loadMoreEnd()
                }else{
                    adapter?.loadMoreComplete()
                }
            }
        })


        adapter?.setOnLoadMoreListener({
            vm?.getArticalSystemList(intent.getIntExtra("cid",0),++pageNum)
        },rv_artical_system)

        adapter?.setOnItemClickListener { adapter, view, position ->

            val bundle= Bundle()
            bundle.putString("url", articalList[position].link)
            bundle.putString("title", articalList[position].title)
            ToActivityHelper.getInstance()?.toActivity(this@ArticalSystemListActivity,MainWebActivity::class.java,bundle)

        }

    }
}
