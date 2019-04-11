package com.yicooll.wanandroidkotlin.api_service

import com.yicooll.wanandroidkotlin.entity.ModelOfficialCodeCategory
import com.yicooll.wanandroidkotlin.entity.ModelOfficialCodeList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface OfficialCodeService {

    @GET("wxarticle/chapters/json ")
    fun getOfficialCodeCategory(): Observable<ModelOfficialCodeCategory>

    @GET
    fun getOfficialCodeList(@Url url:String):Observable<ModelOfficialCodeList>
}