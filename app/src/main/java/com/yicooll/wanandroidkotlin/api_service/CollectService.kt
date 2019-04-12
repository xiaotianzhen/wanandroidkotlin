package com.yicooll.wanandroidkotlin.api_service

import com.yicooll.wanandroidkotlin.entity.ModelCollect
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface CollectService {

    @GET
    fun  getCollectList(@Url url:String):Observable<ModelCollect>
}