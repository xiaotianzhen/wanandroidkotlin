package com.yicooll.wanandroidkotlin.repository

import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.api_service.ArticalSystemService
import com.yicooll.wanandroidkotlin.entity.ModelSystemCatogry
import com.yicooll.wanandroidkotlin.network.RetrofitUtil
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ArticalSystemRepository {


    val catogryLiveData=MutableLiveData<ModelSystemCatogry>()

    init {
        getArticalSystemCatogry()
    }


    fun  getSystemCatogryLiveData():MutableLiveData<ModelSystemCatogry>{
        return catogryLiveData
    }


    fun getArticalSystemCatogry() {

        val client=RetrofitUtil.getRetorfit()
        val service=client!!.create(ArticalSystemService::class.java)
        service.getActicalSystemCatogry()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object :Observer<ModelSystemCatogry>{
                    override fun onComplete() {
                    }

                    override fun onSubscribe(d: Disposable?) {
                    }

                    override fun onNext(model: ModelSystemCatogry?) {
                        catogryLiveData.value=model
                    }

                    override fun onError(e: Throwable?) {
                    }
                })
    }
}
