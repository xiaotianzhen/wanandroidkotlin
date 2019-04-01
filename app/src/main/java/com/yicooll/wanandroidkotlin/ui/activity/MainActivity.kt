package com.yicooll.wanandroidkotlin.ui.activity

import android.databinding.DataBindingUtil
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.TextView
import com.yicooll.wanandroidkotlin.BR
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseActivity
import com.yicooll.wanandroidkotlin.databinding.ActivityMainBinding
import com.yicooll.wanandroidkotlin.ui.fragment.IndexFragment
import com.yicooll.wanandroidkotlin.ui.fragment.MineFragment
import com.yicooll.wanandroidkotlin.ui.fragment.WeigetFragment

class MainActivity : BaseActivity() {


    private val mFragmentList = java.util.ArrayList<Fragment>()

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initViewAndEvent() {

        var bindding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        bindding.setVariable(BR.presenter, Presenter())
        changeFragment(IndexFragment::class.simpleName)

        var llMenu : LinearLayout ?= getHeadMenu ()
        var view: View = layoutInflater.inflate(R.layout.include_noback_toolbar, llMenu)
        var tvTitle: TextView = view.findViewById<TextView>(R.id.tv_menu_center)
        tvTitle.text = "控件"
    }


    class Presenter {

        fun onCheckedChanged(viewGrop: RadioGroup?, checkId: Int) {
            val activity: MainActivity = viewGrop!!.context as MainActivity
            when (checkId) {
                R.id.rb_main -> activity.changeFragment(IndexFragment::class.simpleName)
                R.id.rb_center -> activity.changeFragment(WeigetFragment::class.simpleName)
                R.id.rb_user -> activity.changeFragment(MineFragment::class.simpleName)
            }
        }
    }

    fun changeFragment(tag: String?) {
        hideFragment()
        var transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        var fragment: Fragment? = supportFragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            transaction.show(fragment)
        } else {
            when (tag) {
                IndexFragment::class.simpleName -> {
                    fragment = IndexFragment()
                }
                WeigetFragment::class.simpleName -> {
                    fragment = WeigetFragment()
                }
                MineFragment::class.simpleName -> {
                    fragment = MineFragment()
                }

            }

            if (fragment != null) {
                mFragmentList.add(fragment)
                transaction.add(R.id.fl_layout, fragment, tag)
            }
        }
        transaction.commitAllowingStateLoss()
    }

    /**
     * 隐藏所有的fragment
     */
    fun hideFragment() {
        var transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        for (f in mFragmentList) {
            transaction.hide(f)
        }
        transaction.commit()
    }
}
