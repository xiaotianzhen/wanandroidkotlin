package com.yicooll.wanandroidkotlin.repository

import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.api_service.UserService
import com.yicooll.wanandroidkotlin.entity.ModelLogin
import com.yicooll.wanandroidkotlin.network.RetrofitUtil
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LoginRepository(username: String, password: String) {

    private val liveLoginData = MutableLiveData<ModelLogin>()

    init {
        doLogin(username, password)
    }

    fun getLoginData(): MutableLiveData<ModelLogin> {
        return liveLoginData
    }

    fun doLogin(username: String, password: String) {

        val client = RetrofitUtil.getRetorfit()
        val service = client!!.create(UserService::class.java)
        service.doLogin(username, password)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ModelLogin> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable?) {

                    }

                    override fun onNext(value: ModelLogin?) {
                        liveLoginData.value = value
                    }

                    override fun onError(e: Throwable?) {
                        liveLoginData.value=null
                    }

                })
    }

}