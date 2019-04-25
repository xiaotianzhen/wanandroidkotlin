package com.yicooll.wanandroidkotlin.repository

import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.api_service.CollectService
import com.yicooll.wanandroidkotlin.entity.ModelCollect
import com.yicooll.wanandroidkotlin.network.RetrofitUtil
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class CollectRepository {


    private val collectLiveData = MutableLiveData<ModelCollect>()


    fun getCollectLiveData(): MutableLiveData<ModelCollect> {
        return collectLiveData
    }

    fun getCollectList(pageNum: Int) {

        val clicent = RetrofitUtil.getRetorfit()
        val service = clicent!!.create(CollectService::class.java)
        val url = "lg/collect/list/$pageNum/json"
        service.getCollectList(url)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ModelCollect> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable?) {

                    }

                    override fun onNext(value: ModelCollect?) {
                        collectLiveData.value = value
                    }

                    override fun onError(e: Throwable?) {
                        collectLiveData.value = null
                    }

                })
    }

}
