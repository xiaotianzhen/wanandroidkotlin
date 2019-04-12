package com.yicooll.wanandroidkotlin.network

import android.util.Log
import com.yicooll.wanandroidkotlin.App
import com.yicooll.wanandroidkotlin.utils.PreferenceHelper
import okhttp3.Interceptor
import okhttp3.Response

class AddCookiesInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        val builder=chain!!.request().newBuilder()
        val preferences=PreferenceHelper.getStringSet(App.getInstance()!!.applicationContext,"cookie")

        if(preferences!=null){
                for(cookie in preferences){
                    builder.addHeader("Cookie",cookie)
                    Log.v("OkHttp", "Adding Header: $cookie")
                    // This is done so I know which headers are being added; this interceptor is used after the normal logging of OkHttp
                }
        }

        return  chain.proceed(builder.build())
    }
}