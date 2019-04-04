package com.yicooll.wanandroidkotlin.api_service

import com.yicooll.wanandroidkotlin.entity.ModelLogin
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserService {


   @POST("user/login")
   @FormUrlEncoded
   fun doLogin(@Field("username")username:String, @Field("password")password:String):Observable<ModelLogin>

}