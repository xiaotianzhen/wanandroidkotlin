package com.yicooll.wanandroidkotlin.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.entity.ModelIndexArtical
import com.yicooll.wanandroidkotlin.entity.ModelIndexBanner
import com.yicooll.wanandroidkotlin.repository.IndexRepository

class IndexViewModel(application: Application):AndroidViewModel(application) {

    private var indexBannerLiveData : MutableLiveData<ModelIndexBanner>?=null
    private var repository:IndexRepository?=null
    private var indexArticalLiveData:MutableLiveData<ModelIndexArtical>?=null
    init {
        repository=IndexRepository()
        indexBannerLiveData= repository?.getBannerLiveData()
        indexArticalLiveData=repository?.getArticalLiveData()
    }

    fun getIndexBanner(){
        repository?.getIndexBanner()
    }

    fun getIndexArtical(pageNum:Int){
        repository?.getIndexArtical(pageNum)
    }

    fun getBannerLiveData():MutableLiveData<ModelIndexBanner>?{
        return indexBannerLiveData
    }

    fun getArticalLiveData():MutableLiveData<ModelIndexArtical>?{
        return indexArticalLiveData
    }

}