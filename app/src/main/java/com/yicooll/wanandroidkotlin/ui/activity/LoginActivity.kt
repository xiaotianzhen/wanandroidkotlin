package com.yicooll.wanandroidkotlin.ui.activity


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseActivity
import com.yicooll.wanandroidkotlin.entity.ModelLogin
import com.yicooll.wanandroidkotlin.util.PreferenceHelper
import com.yicooll.wanandroidkotlin.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity() {

    private var vm: LoginViewModel? = null


    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_login
    }


    override fun initView() {
        var llMenu: LinearLayout? = getHeadMenu()
        var view: View = layoutInflater.inflate(R.layout.include_base_toolbar, llMenu)
        var tvTitle: TextView = view.findViewById<TextView>(R.id.tv_menu_center)
        tvTitle.text = "登录"

    }

    override fun initEvent() {
        vm = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        //vm!!.init(et_usernmae.text.toString(), et_password.text.toString())

        tv_login.setOnClickListener {
            invalidateInfo()
        }
    }


    fun loginSuccess(it1: ModelLogin?) {
        showToast("登录成功")
        PreferenceHelper.putBoolean(this, "isLogin", true)
        finish()
    }


    private fun invalidateInfo() {
        if (et_usernmae.text.toString().trim() == "") {
            showToast("请输入用户名")
            return
        }
        if (et_password.text.toString().trim() == "") {
            showToast("请输入密码")
            return
        }
        if (et_password.text.toString().length < 6) {
            showToast("请输入6位以上密码")
            return
        }
        vm?.doLogin(et_usernmae.text.toString().trim(), et_password.text.toString().trim())

        vm!!.getLodinData()?.observe(this, Observer {
            it.let {

                it1 ->
                loginSuccess(it1)

            }
        })
    }
}
