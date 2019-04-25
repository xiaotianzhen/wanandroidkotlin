package com.yicooll.wanandroidkotlin.repository

import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.api_service.ArticalSystemService
import com.yicooll.wanandroidkotlin.entity.ModelArticalSystemList
import com.yicooll.wanandroidkotlin.network.RetrofitUtil
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ArticalSystemListRepository(cid: Int,pageNum:Int) {

    private var articalSystemListLiveData = MutableLiveData<ModelArticalSystemList>()

    init {
        getArticalSystemList(cid,pageNum)
    }

    fun getArticalSystemListLiveData(): MutableLiveData<ModelArticalSystemList> {
        return articalSystemListLiveData
    }


    fun getArticalSystemList(cid: Int,pageNum:Int) {
        val client = RetrofitUtil.getRetorfit()
        val service = client!!.create(ArticalSystemService::class.java)
        var url = "article/list/$pageNum/json?cid=$cid"
        service.getArticalSystemList(url)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ModelArticalSystemList> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable?) {
                    }

                    override fun onNext(value: ModelArticalSystemList?) {
                        articalSystemListLiveData.value = value
                    }

                    override fun onError(e: Throwable?) {
                        articalSystemListLiveData.value = null
                    }
                })
    }
}