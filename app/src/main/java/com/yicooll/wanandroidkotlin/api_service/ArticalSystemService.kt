package com.yicooll.wanandroidkotlin.api_service

import com.yicooll.wanandroidkotlin.entity.ModelArticalSystemList
import com.yicooll.wanandroidkotlin.entity.ModelSystemCatogry
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface ArticalSystemService {

    @GET("tree/json")
    fun  getActicalSystemCatogry():Observable<ModelSystemCatogry>

    @GET
    fun getArticalSystemList(@Url url:String):Observable<ModelArticalSystemList>
}