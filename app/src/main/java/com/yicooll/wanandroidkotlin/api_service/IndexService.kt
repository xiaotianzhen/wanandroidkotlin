package com.yicooll.wanandroidkotlin.api_service

import com.yicooll.wanandroidkotlin.entity.ModelIndexArtical
import com.yicooll.wanandroidkotlin.entity.ModelIndexBanner
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface IndexService {

    @GET("banner/json")
    fun getIndexBanner() :Observable<ModelIndexBanner>

    @GET
    fun getIndexArtical(@Url url:String) :Observable<ModelIndexArtical>
}