package com.yicooll.wanandroidkotlin.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.entity.ModelCollect
import com.yicooll.wanandroidkotlin.repository.CollectRepository

class CollectViewModel(application: Application) : AndroidViewModel(application) {


    private var collectLiveData: MutableLiveData<ModelCollect>? = null
    private var repository: CollectRepository? = null


    fun getCollectLiveData(): MutableLiveData<ModelCollect>? {
        return collectLiveData
    }

    fun getCollectList(pageNum: Int) {
        repository = CollectRepository()
        repository?.getCollectList(pageNum)
        collectLiveData = repository?.getCollectLiveData()
    }
}