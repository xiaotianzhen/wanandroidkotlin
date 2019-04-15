package com.yicooll.wanandroidkotlin.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.yicooll.wanandroidkotlin.R
import kotlinx.android.synthetic.main.activity_base.*

abstract class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initEvent()
    }

    protected abstract fun initView()
    protected abstract fun initEvent()

    /**
     * toast 消息
     */
    protected fun showToast(msg: String) {
        if (msg != null && !TextUtils.isEmpty(msg)) {
            Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
        }
    }
}