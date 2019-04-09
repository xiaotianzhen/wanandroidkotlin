package com.yicooll.wanandroidkotlin.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.entity.ModelSystemCatogry
import com.yicooll.wanandroidkotlin.repository.ArticalSystemRepository

class ArticalSystemViewModel(application: Application) : AndroidViewModel(application) {

    var repository: ArticalSystemRepository? = null
    var systemCatogoryLiveData: MutableLiveData<ModelSystemCatogry>? = null

    init {
        repository = ArticalSystemRepository()
        systemCatogoryLiveData = repository?.getSystemCatogryLiveData()
    }


    fun getArticalSystemCatogry() {
        repository?.getArticalSystemCatogry()
    }


    fun getSystemCatogryLiveData(): MutableLiveData<ModelSystemCatogry>? {
        return systemCatogoryLiveData
    }

}