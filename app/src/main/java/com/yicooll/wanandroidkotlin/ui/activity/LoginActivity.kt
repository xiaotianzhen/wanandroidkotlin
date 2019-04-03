package com.yicooll.wanandroidkotlin.ui.activity


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.yicooll.wanandroidkotlin.BR
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseActivity
import com.yicooll.wanandroidkotlin.databinding.ActivityLoginBinding
import com.yicooll.wanandroidkotlin.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity() {


    private var vm: LoginViewModel? = null
    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initViewAndEvent() {
        var bindding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        bindding.setVariable(BR.presenter, Presenter())



        vm = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        vm!!.init(et_usernmae.text.toString(), et_password.text.toString())

        vm!!.getLodinData()?.observe(this, Observer {
            it.let {

                it1 ->loginSuccess(it1)

            }
        })

        var llMenu: LinearLayout? = getHeadMenu()
        var view: View = layoutInflater.inflate(R.layout.include_base_toolbar, llMenu)
        var tvTitle: TextView = view.findViewById<TextView>(R.id.tv_menu_center)
        tvTitle.text = "登录"
    }

    fun loginSuccess(it1:String?){
          showToast(it1)
    }


    inner class Presenter {

        fun onLoginClick(view: View) {
              showToast("登录")
        }
    }
}
