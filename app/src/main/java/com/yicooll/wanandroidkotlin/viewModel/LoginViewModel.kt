package com.yicooll.wanandroidkotlin.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.entity.ModelLogin
import com.yicooll.wanandroidkotlin.repository.LoginRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: LoginRepository? = null

    fun doLogin(username: String, password: String) {
        repository = LoginRepository(username,password)
    }

    fun getLodinData(): MutableLiveData<ModelLogin>? {

        return repository?.getLoginData()
    }
}