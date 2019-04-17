package com.yicooll.wanandroidkotlin.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.TranslateAnimation

import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseFragment
import com.yicooll.wanandroidkotlin.ui.fragment.goodschild.GoodsConfigFragment
import com.yicooll.wanandroidkotlin.ui.fragment.goodschild.GoodsInfoWebFragment
import com.yicooll.wanandroidkotlin.utils.Util
import kotlinx.android.synthetic.main.fragment_goods_info_detail_main.*


/**
 * A simple [Fragment] subclass.
 *
 */
class GoodsInfoDetailMainFragment : BaseFragment() {


    private var configFragment: GoodsConfigFragment? = null
    private var webFragment: GoodsInfoWebFragment? = null
    private var currentFragment: Fragment? = null
    private var nowIndex: Int = 0
    private var fromX: Float = 0.toFloat()
    private var manager: FragmentManager? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_goods_info_detail_main, container, false)
    }

    override fun initView() {
        webFragment = GoodsInfoWebFragment()
        configFragment = GoodsConfigFragment()

        currentFragment = webFragment
        manager = childFragmentManager
        manager!!.beginTransaction().replace(R.id.fl_goods_content, currentFragment!!).commitAllowingStateLoss()

        var params = v_tab_cursor.layoutParams
        params.width = Util.getWindowMetrics(activity!!)[0] / 2
        v_tab_cursor.layoutParams = params

    }

    override fun initEvent() {
        tv_goods_detail.setOnClickListener {
            switchFragment(currentFragment, webFragment)
            currentFragment = webFragment
            nowIndex = 0
            scrollCursor()
        }

        tv_goods_config.setOnClickListener {
            switchFragment(currentFragment, configFragment)
            currentFragment = configFragment
            nowIndex = 1
            scrollCursor()
        }
    }

    private fun scrollCursor() {


        val translateAnimation = TranslateAnimation(fromX, (nowIndex * v_tab_cursor.width).toFloat(), 0f, 0f)
        translateAnimation.fillAfter = true  //设置动画结束时停在动画结束的位置
        translateAnimation.duration = 50
        //保存动画结束时游标的位置,作为下次滑动的起点
        fromX = (nowIndex * v_tab_cursor.width).toFloat()
        v_tab_cursor.startAnimation(translateAnimation)

        if (nowIndex == 0) {
            tv_goods_detail.setTextColor(resources.getColor(R.color.font_red))
            tv_goods_config.setTextColor(resources.getColor(R.color.font_stronger))
        } else {
            tv_goods_detail.setTextColor(resources.getColor(R.color.font_stronger))
            tv_goods_config.setTextColor(resources.getColor(R.color.font_red))
        }
    }


    private fun switchFragment(fromFragment: Fragment?, toFragment: Fragment?) {
        if (fromFragment != toFragment) {
            val fragmentTransient = manager?.beginTransaction()
            if (toFragment != null && fromFragment != null) {
                if (toFragment.isAdded) {
                    fragmentTransient!!.hide(fromFragment).show(toFragment).commitAllowingStateLoss()
                } else {
                    fragmentTransient!!.hide(fromFragment).add(R.id.fl_goods_content, toFragment).commitAllowingStateLoss()
                }
            }
        }
    }
}
