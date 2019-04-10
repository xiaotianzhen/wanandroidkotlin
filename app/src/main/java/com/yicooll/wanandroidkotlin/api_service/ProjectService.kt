package com.yicooll.wanandroidkotlin.api_service

import com.yicooll.wanandroidkotlin.entity.ModelProjectCategory
import com.yicooll.wanandroidkotlin.entity.ModelProjectList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface ProjectService {

    @GET
    fun  getProjectByType(@Url url:String):Observable<ModelProjectList>


    @GET("project/tree/json")
    fun  getProjectCategory():Observable<ModelProjectCategory>
}