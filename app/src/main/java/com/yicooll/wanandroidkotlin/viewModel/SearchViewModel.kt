package com.yicooll.wanandroidkotlin.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.entity.ModelSearch
import com.yicooll.wanandroidkotlin.repository.SearchRepository

class SearchViewModel(application: Application):AndroidViewModel(application) {


    private var repository:SearchRepository?=null
    private var searchLiveData:MutableLiveData<ModelSearch>?=null

    init {
        repository= SearchRepository()
        searchLiveData=repository?.getSearchLiveData()
    }


    fun getSearchLiveData(): MutableLiveData<ModelSearch>? {
        return searchLiveData
    }

    fun getSearchData(keyword: String, pageNum: Int){
        repository?.getSearchData(keyword,pageNum)
    }
}