package com.yicooll.wanandroidkotlin.api_service

import com.yicooll.wanandroidkotlin.entity.ModelOfficialCodeCategory
import io.reactivex.Observable
import retrofit2.http.GET

interface OfficialCodeService {

    @GET("wxarticle/chapters/json ")
    fun getOfficialCodeCategory(): Observable<ModelOfficialCodeCategory>
}