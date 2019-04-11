package com.yicooll.wanandroidkotlin.api_service

import com.yicooll.wanandroidkotlin.entity.ModelSearch
import io.reactivex.Observable
import retrofit2.http.*

interface  SearchService{

    @POST
    @FormUrlEncoded
    fun  searchArtical(@Url url:String,@Field("k")word:String):Observable<ModelSearch>
}