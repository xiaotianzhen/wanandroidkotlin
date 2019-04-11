package com.yicooll.wanandroidkotlin.ui.activity

import android.arch.lifecycle.ViewModelProviders
import android.text.TextUtils
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseActivity
import com.yicooll.wanandroidkotlin.viewModel.SearchViewModel
import kotlinx.android.synthetic.main.activity_search.*


class SearchActivity : BaseActivity() {

    private var vm:SearchViewModel?=null
    private var pageNum=1

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_search
    }

    override fun initView() {
    }

    override fun initEvent() {

        vm=ViewModelProviders.of(this).get(SearchViewModel::class.java)
        obt_search.setOnClickListener {

            if(!TextUtils.isEmpty(edt_search.text.toString())){
                pageNum=1
                vm?.getSearchData(edt_search.text.toString(),pageNum)
            }
        }
    }
}
