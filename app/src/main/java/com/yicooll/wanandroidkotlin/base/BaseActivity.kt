package com.yicooll.wanandroidkotlin.base

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.gyf.barlibrary.ImmersionBar
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.entity.Event
import com.yicooll.wanandroidkotlin.utils.Density
import de.greenrobot.event.EventBus
import de.greenrobot.event.Subscribe
import kotlinx.android.synthetic.main.activity_base.*

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Density.setCustomDensity(this, application)
        setContentView(R.layout.activity_base)
        var view: View = layoutInflater.inflate(getContentViewLayoutId(), ll_content, false)
        ll_content.addView(view)
        if (regEvent() && !EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
        initView()
        initEvent()
        ImmersionBar.with(this).fitsSystemWindows(true).statusBarColor(R.color.bg_main_color).init()
    }

    protected abstract fun getContentViewLayoutId(): Int

    protected abstract fun initView()
    protected abstract fun initEvent()


    /**
     * 获取头部菜单布局
     */
    protected fun getHeadMenu(): LinearLayout? {
        return if (ll_menu != null) {
            ll_menu.visibility = View.VISIBLE
            ll_menu
        } else {
            null
        }
    }

    /**
     * toast 消息
     */
    protected fun showToast(msg: String?) {
        if (msg != null && !TextUtils.isEmpty(msg)) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }

    /**
     *
     * 导航返回onClick属性
     */
    fun back(view: View) {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (regEvent()) {
            EventBus.getDefault().unregister(this)
        }
        ImmersionBar.with(this).destroy()
    }

    /**
     * 需要接收事件 重写该方法 并返回true
     */
    private fun regEvent(): Boolean {
        return false
    }


    @Subscribe
    open fun onEvent(event: Event<Any>) {

    }
}