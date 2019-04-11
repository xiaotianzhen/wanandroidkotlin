package com.yicooll.wanandroidkotlin.repository

import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.api_service.SearchService
import com.yicooll.wanandroidkotlin.entity.ModelSearch
import com.yicooll.wanandroidkotlin.network.RetrofitUtil
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SearchRepository {

    private var searchLiveData = MutableLiveData<ModelSearch>()

    fun getSearchLiveData(): MutableLiveData<ModelSearch> {
        return searchLiveData
    }

    fun getSearchData(keyword: String, pageNum: Int) {

        val client = RetrofitUtil.getRetorfit()
        val service = client!!.create(SearchService::class.java)
        var url = "article/query/$pageNum/json"
        service.searchArtical(url, keyword)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ModelSearch> {
                    override fun onComplete() {
                    }

                    override fun onSubscribe(d: Disposable?) {
                    }

                    override fun onNext(value: ModelSearch?) {
                        searchLiveData.value = value
                    }

                    override fun onError(e: Throwable?) {
                    }
                })
    }
}