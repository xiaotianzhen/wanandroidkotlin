package com.yicooll.wanandroidkotlin.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.repository.LoginRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {




    private var repository: LoginRepository? = null
    private var data: MutableLiveData<String>? = null

    fun init(username: String,password: String){
        repository = LoginRepository(username,password)
        data = repository?.getLoginData()
    }

    fun doLogin(username: String, password: String) {
        repository?.doLogin(username, password)
    }

    fun getLodinData(): MutableLiveData<String>? {
        return data
    }
}