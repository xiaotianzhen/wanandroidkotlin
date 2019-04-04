package com.yicooll.wanandroidkotlin.ui.activity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseActivity
import com.yicooll.wanandroidkotlin.ui.fragment.IndexFragment
import com.yicooll.wanandroidkotlin.ui.fragment.MineFragment
import com.yicooll.wanandroidkotlin.ui.fragment.WeigetFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_noback_toolbar.*

class MainActivity : BaseActivity() {


    private val mFragmentList = java.util.ArrayList<Fragment>()
    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initViewAndEvent() {


        var llMenu = getHeadMenu()
        layoutInflater.inflate(R.layout.include_noback_toolbar, llMenu)
        tv_menu_center.text = "首页"

        changeFragment(IndexFragment::class.simpleName)
        rg_main.setOnCheckedChangeListener { radioGroup, checkId ->
            when (checkId) {
                R.id.rb_main -> {
                    changeFragment(IndexFragment::class.simpleName)
                    tv_menu_center.text = "首页"
                }
                R.id.rb_center -> {
                    changeFragment(WeigetFragment::class.simpleName)
                    tv_menu_center.text = "控件"
                }
                R.id.rb_user -> {
                    tv_menu_center.text = "我的"
                    changeFragment(MineFragment::class.simpleName)
                }

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
