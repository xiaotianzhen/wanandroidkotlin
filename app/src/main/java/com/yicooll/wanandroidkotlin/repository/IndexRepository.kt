package com.yicooll.wanandroidkotlin.repository

import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.api_service.IndexService
import com.yicooll.wanandroidkotlin.entity.ModelIndexArtical
import com.yicooll.wanandroidkotlin.entity.ModelIndexBanner
import com.yicooll.wanandroidkotlin.network.RetrofitUtil
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class IndexRepository {


    private var indexBannerLiveData=MutableLiveData<ModelIndexBanner>()
    private var indexArticalLiveData=MutableLiveData<ModelIndexArtical>()


    init {
        getIndexBanner()
        getIndexArtical(1)
    }

     fun getIndexArtical(pageNum:Int) {
        val client = RetrofitUtil.getRetorfit()
        val service = client!!.create(IndexService::class.java)
        service.getIndexArtical("article/list/$pageNum/json")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :Observer<ModelIndexArtical>{

                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable?) {

                    }

                    override fun onNext(value: ModelIndexArtical?) {
                        indexArticalLiveData.value=value
                    }

                    override fun onError(e: Throwable?) {
                        indexArticalLiveData.value=null
                    }
                })

    }

    fun getBannerLiveData():MutableLiveData<ModelIndexBanner>{
        return  indexBannerLiveData
    }

    fun getArticalLiveData():MutableLiveData<ModelIndexArtical>{
        return indexArticalLiveData
    }

    fun getIndexBanner() {
        val client = RetrofitUtil.getRetorfit()
        val service = client!!.create(IndexService::class.java)
        service.getIndexBanner()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :Observer<ModelIndexBanner>{
                    override fun onComplete() {
                    }

                    override fun onSubscribe(d: Disposable?) {
                    }

                    override fun onNext(value: ModelIndexBanner?) {
                        indexBannerLiveData.value=value
                    }

                    override fun onError(e: Throwable?) {
                        indexBannerLiveData.value=null
                    }

                })
    }
}