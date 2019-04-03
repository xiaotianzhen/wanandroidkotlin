package com.yicooll.wanandroidkotlin.api_service

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserService {


   @POST("user/login")
   @FormUrlEncoded
   fun doLogin(@Field("username")username:String, @Field("password")password:String):Observable<String>

}