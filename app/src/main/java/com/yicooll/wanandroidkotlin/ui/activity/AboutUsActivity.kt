package com.yicooll.wanandroidkotlin.ui.activity

import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseActivity
import kotlinx.android.synthetic.main.include_noback_toolbar.*

class AboutUsActivity : BaseActivity() {
    override fun getContentViewLayoutId(): Int {
       return R.layout.activity_about_us
    }

    override fun initView() {
        var llMenu = getHeadMenu()
        layoutInflater.inflate(R.layout.include_base_toolbar, llMenu)
        tv_menu_center.text = "关于我们"
    }

    override fun initEvent() {



    }
}
