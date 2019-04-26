package com.yicooll.wanandroidkotlin.ui.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import com.yicooll.wanandroidkotlin.Constant
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseActivity
import com.yicooll.wanandroidkotlin.entity.ModelSystemCatogry
import com.yicooll.wanandroidkotlin.ui.adapter.ArticalSystemAdapter
import com.yicooll.wanandroidkotlin.ui.adapter.ArticalSystemChildrenAdapter
import com.yicooll.wanandroidkotlin.utils.ToActivityHelper
import com.yicooll.wanandroidkotlin.viewModel.ArticalSystemViewModel
import kotlinx.android.synthetic.main.activity_artical_system.*
import kotlinx.android.synthetic.main.activity_artical_system_list.*
import kotlinx.android.synthetic.main.include_noback_toolbar.*

class ArticalSystemActivity : BaseActivity() {


    private var vm: ArticalSystemViewModel? = null
    private var categoryData = ArrayList<ModelSystemCatogry.Data>()
    private var categoryChildData = ArrayList<ModelSystemCatogry.Data.Children>()
    private var articalSystemAdapter: ArticalSystemAdapter? = null
    private var articalSystemChildrenAdapter: ArticalSystemChildrenAdapter? = null


    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_artical_system
    }

    override fun initView() {
        var llMenu = getHeadMenu()
        layoutInflater.inflate(R.layout.include_base_toolbar, llMenu)
        tv_menu_center.text = "体系"

        articalSystemAdapter = ArticalSystemAdapter(R.layout.adapter_category_item, categoryData)
        rv_p_category.layoutManager = LinearLayoutManager(this)
        rv_p_category.adapter = articalSystemAdapter

        articalSystemChildrenAdapter = ArticalSystemChildrenAdapter(R.layout.adapter_category_item, categoryChildData)
        rv_c_category.layoutManager = LinearLayoutManager(this)
        rv_c_category.adapter = articalSystemChildrenAdapter

        srv_system.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light)
    }

    private val mHandler = Handler {
        vm?.getArticalSystemCatogry()
        srv_system.isRefreshing = false
        return@Handler true
    }

    override fun initEvent() {

        srv_system.setOnRefreshListener {
            mHandler.sendEmptyMessageDelayed(Constant.FRESH_CODE, Constant.LOADING_DELAYED)
        }

        vm = ViewModelProviders.of(this).get(ArticalSystemViewModel::class.java)
        vm?.systemCatogoryLiveData?.observe(this, Observer {
            categoryData.clear()
            it?.let {

                it1 ->
                if (it1.errorCode == 0) {
                    categoryData.addAll(it1.data)
                } else {
                    showToast(it1.errorMsg)
                }

            }
            if (it == null) {
                showToast(Constant.NETWORK_ERROR)
            }
            articalSystemAdapter?.notifyDataSetChanged()
        })
        articalSystemAdapter?.setCustomerItemClickListener(object : ArticalSystemAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                categoryChildData.clear()
                categoryChildData.addAll(categoryData[position].children)
                articalSystemChildrenAdapter?.update()
            }
        })

        articalSystemChildrenAdapter?.setCustomerItemClickListener(object : ArticalSystemChildrenAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val bundle = Bundle()
                bundle.putString("title", categoryChildData[position].name)
                bundle.putInt("cid", categoryChildData[position].id)
                ToActivityHelper.getInstance()?.toActivity(this@ArticalSystemActivity, ArticalSystemListActivity::class.java, bundle)
            }
        })
    }
}
