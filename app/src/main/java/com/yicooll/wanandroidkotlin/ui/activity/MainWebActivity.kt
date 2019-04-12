package com.yicooll.wanandroidkotlin.ui.activity

import android.content.DialogInterface
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.app.AlertDialog
import android.view.View
import android.webkit.*
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main_web.*
import kotlinx.android.synthetic.main.include_base_toolbar.*

class MainWebActivity : BaseActivity() {


    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_main_web
    }

    override fun initView() {
        var llMenu = getHeadMenu()
        layoutInflater.inflate(R.layout.include_base_toolbar, llMenu)
        var url = ""
        if (intent !== null) {
            tv_menu_center.text = intent.getStringExtra("title")
            url = intent.getStringExtra("url")
        }
        wvSetting()
        webview.loadUrl(url)
    }

    override fun initEvent() {
        im_back.setOnClickListener {
            if (webview.canGoBack()) {
                webview.goBack()
            } else {
                finish()
            }
        }
    }


    fun wvSetting() {

        val webSetting=webview.settings
        webSetting.javaScriptEnabled=true
        //允许js弹框
        webSetting.javaScriptCanOpenWindowsAutomatically=true

        //解决高版本webview不能点击
        webview.webViewClient=object :WebViewClient(){

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

        // 由于设置了弹窗检验调用结果,所以需要支持js对话框
        // webview只是载体，内容的渲染需要使用webviewChromClient类去实现
        // 通过设置WebChromeClient对象处理JavaScript的对话框
        //设置响应js 的Alert()函数

        webview.webChromeClient=object : WebChromeClient() {

            override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                val b = AlertDialog.Builder(this@MainWebActivity)
                b.setTitle("Alert")
                b.setMessage(message)
                b.setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, which -> result?.confirm() })
                b.setCancelable(false)
                b.create().show()
                return true
            }

            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if(newProgress==100){
                    pgb_webview.visibility= View.GONE
                }else{
                    pgb_webview.visibility= View.VISIBLE
                    pgb_webview.progress = newProgress
                }
            }
        }
    }
}
