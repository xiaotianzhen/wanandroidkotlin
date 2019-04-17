package com.yicooll.wanandroidkotlin.ui.activity

import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseActivity
import com.yicooll.wanandroidkotlin.ui.fragment.GoodsCommentFragment
import com.yicooll.wanandroidkotlin.ui.fragment.GoodsInfoDetailMainFragment
import com.yicooll.wanandroidkotlin.ui.fragment.GoodsInfoMainFragment
import kotlinx.android.synthetic.main.activity_shop_detail.*

class ShopDetailActivity : BaseActivity() {


    private val fragmentList = ArrayList<Fragment>()
    private val titleArray = arrayOf("商品", "详情", "评价")

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_shop_detail
    }

    override fun initView() {

        var llMenu = getHeadMenu()
        val view = layoutInflater.inflate(R.layout.include_tab_toolbar, llMenu)
        val tablayout = view.findViewById<TabLayout>(R.id.tab_detial_type)
        fragmentList.clear()
        val mainFragment = GoodsInfoMainFragment()
        fragmentList.add(mainFragment)
        val detialFragment = GoodsInfoDetailMainFragment()
        fragmentList.add(detialFragment)
        val commentFragment = GoodsCommentFragment()
        fragmentList.add(commentFragment)
        viewpager.adapter = VpAdapter(supportFragmentManager)
        tablayout.setupWithViewPager(viewpager)
    }

    override fun initEvent() {


    }


    fun setCurrentPage(position: Int){
        viewpager.currentItem = position
    }

    inner class VpAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {

            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleArray[position]
        }

    }

}
