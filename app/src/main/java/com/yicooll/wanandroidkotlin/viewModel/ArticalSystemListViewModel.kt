package com.yicooll.wanandroidkotlin.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.entity.ModelArticalSystemList
import com.yicooll.wanandroidkotlin.repository.ArticalSystemListRepository

class ArticalSystemListViewModel(application: Application):AndroidViewModel(application) {

    private var repository:ArticalSystemListRepository?=null
    private var articalSystemListLiveData : MutableLiveData<ModelArticalSystemList>?=null

    fun initRequest(cid:Int,pageNum:Int){
        repository=ArticalSystemListRepository(cid,pageNum)
        articalSystemListLiveData= repository?.getArticalSystemListLiveData()
    }


    fun getArticalSystemListLiveData(): MutableLiveData<ModelArticalSystemList>? {
        return articalSystemListLiveData
    }


    fun getArticalSystemList(cid: Int,pageNum:Int) {
        repository?.getArticalSystemList(cid,pageNum)
    }
}