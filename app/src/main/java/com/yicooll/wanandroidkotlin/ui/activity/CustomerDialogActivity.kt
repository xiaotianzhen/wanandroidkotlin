package com.yicooll.wanandroidkotlin.ui.activity


import android.os.Handler
import android.view.View
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_customer_dialog.*

class CustomerDialogActivity : BaseActivity() {

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_customer_dialog
    }

    override fun initView() {
        mHandler.sendEmptyMessageDelayed(1000, 5000)
    }

    override fun initEvent() {
    }

    private val mHandler = Handler {
        loading_view.visibility = View.GONE
        return@Handler true
    }
}
