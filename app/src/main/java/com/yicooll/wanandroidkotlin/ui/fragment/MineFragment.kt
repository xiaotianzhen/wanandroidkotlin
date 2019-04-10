package com.yicooll.wanandroidkotlin.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseFragment
import com.yicooll.wanandroidkotlin.ui.activity.LoginActivity
import com.yicooll.wanandroidkotlin.utils.ImageUtils
import com.yicooll.wanandroidkotlin.utils.ToActivityHelper
import com.yicooll.wanandroidkotlin.utils.UserHelper
import kotlinx.android.synthetic.main.fragment_mine.*


/**
 * A simple [Fragment] subclass.
 *
 */
class MineFragment : BaseFragment() {


    override fun onResume() {
        super.onResume()
        displayView()
    }


    override fun initView() {
        ImageUtils.loadImageBlur(iv_bg, url)
        ImageUtils.loadImageCircle(iv_head, url)
    }

    override fun initEvent() {
        tv_login.setOnClickListener {
            ToActivityHelper.getInstance()!!.toActivity(activity!!, LoginActivity::class.java)
        }

        tv_login_out.setOnClickListener {
            UserHelper.getInstance()?.loginOut(activity!!.applicationContext)
            displayView()
        }
    }


    fun displayView() {
        if (UserHelper.getInstance()?.isLogin(activity!!.applicationContext)!!) {
            tv_login_out.visibility = View.VISIBLE
            tv_login.visibility = View.GONE
            iv_head.visibility = View.VISIBLE
        } else {
            tv_login_out.visibility = View.GONE
            tv_login.visibility = View.VISIBLE
            iv_head.visibility = View.GONE
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_mine, container, false)
    }

    companion object {
        val url: String = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542110989472&di=e206dfdad3d1197025ddc03bca0b013c&imgtype=0&src=http%3A%2F%2Fwww.pig66.com%2Fuploadfile%2F2017%2F1209%2F20171209121323978.png"
    }
}
