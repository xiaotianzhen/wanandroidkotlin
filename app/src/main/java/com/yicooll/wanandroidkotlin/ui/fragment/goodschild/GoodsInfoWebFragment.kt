package com.yicooll.wanandroidkotlin.ui.fragment.goodschild


import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*

import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_goods_info_web.*

class GoodsInfoWebFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_goods_info_web, container, false)
    }

    override fun initView() {
        wvSetting()
        webview.loadUrl("http://m.okhqb.com/item/description/1000334264.html?fromApp=true")

    }

    override fun initEvent() {
        webview.webViewClient = object : WebViewClient() {

            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }
        }
    }

    fun wvSetting() {

        val webSetting = webview.settings
        webSetting.javaScriptEnabled = true
        //允许js弹框
        webSetting.javaScriptCanOpenWindowsAutomatically = true

        //解决高版本webview不能点击
        webview.webViewClient = object : WebViewClient() {

            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
                //用javascript隐藏系统定义的404页面信息
                val data = "Page NO FOUND"
                view?.loadUrl("javascript:document.body.innerHTML=\"$data\"")
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (webview != null) {
            val parent = webview.parent
            if (parent != null) {
                (parent as ViewGroup).removeView(webview)
            }
            webview.stopLoading()
            // 退出时调用此方法，移除绑定的服务，否则某些特定系统会报错
            webview.settings.javaScriptEnabled = false
            webview.clearHistory()
            webview.removeAllViews()
            webview.destroy()
        }

    }
}
