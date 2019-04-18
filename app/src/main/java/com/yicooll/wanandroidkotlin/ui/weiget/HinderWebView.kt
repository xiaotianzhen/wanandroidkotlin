package com.yicooll.wanandroidkotlin.ui.weiget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.webkit.WebView


/**
 * Describe: 滑动中阻碍事件传递 当滑动到顶部 将事件传递给父类
 */
class HinderWebView(context: Context, attrs: AttributeSet) : WebView(context, attrs) {

    private var t = 0
    private var oldY = 0f
    private var oldX = 0f

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when (event?.action) {

            MotionEvent.ACTION_DOWN -> {
                oldY = event.y
                oldX = event.x
                requestDisallowInterceptTouchEvent(true)
            }

            MotionEvent.ACTION_MOVE -> {
                var nowY = event.y
                var nowX = event.x
                if (Math.abs(nowY - oldY) > Math.abs(nowX - oldX)) {
                    //滑动到顶部让父控件重新获得触摸事件
                    if (nowY - oldY > 0 && t == 0) {
                        requestDisallowInterceptTouchEvent(false)
                    }
                } else {
                    requestDisallowInterceptTouchEvent(false)
                }
            }

            MotionEvent.ACTION_UP -> {
                requestDisallowInterceptTouchEvent(true)
            }
        }
        return super.onTouchEvent(event)
    }


    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        this.t = t
        super.onScrollChanged(l, t, oldl, oldt)
    }
}