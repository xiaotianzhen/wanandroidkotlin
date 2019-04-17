package com.yicooll.wanandroidkotlin.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseFragment
import com.yicooll.wanandroidkotlin.entity.Template
import com.yicooll.wanandroidkotlin.ui.activity.ShopDetailActivity
import com.yicooll.wanandroidkotlin.ui.adapter.WeigetAdapter
import com.yicooll.wanandroidkotlin.utils.ToActivityHelper
import kotlinx.android.synthetic.main.fragment_weiget.*


/**
 * A simple [Fragment] subclass.
 *
 */
class WeigetFragment : BaseFragment() {

    private val templateList = ArrayList<Template>()
    private var adapter: WeigetAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_weiget, container, false)
    }

    override fun initView() {
        adapter = WeigetAdapter(R.layout.adapter_weiget_list, getWeigetData())
        rv_weiget.adapter = adapter
        rv_weiget.layoutManager = GridLayoutManager(activity, 3, GridLayoutManager.VERTICAL, false)
    }

    override fun initEvent() {
        adapter?.setOnItemClickListener { adapter, view, position ->

            when(position){
                0-> ToActivityHelper.getInstance()?.toActivity(activity!!,ShopDetailActivity::class.java)
            }

        }
    }


    fun getWeigetData(): ArrayList<Template> {
        templateList.clear()
        templateList.add(Template(R.mipmap.main_icon_1, "商城", "电商商品模板，和jd相似"))
        templateList.add(Template(R.mipmap.main_icon_2, "多功能选择器", "时间，日期，地址，自定义数据滑动器"))
        templateList.add(Template(R.mipmap.main_icon_3, "观察者按钮", "利用按钮对多个输入框监听"))
        templateList.add(Template(R.mipmap.main_icon_4, "流式布局", "从左上角位置开始，自动换行"))
        templateList.add(Template(R.mipmap.main_icon_5, "聊天", "多功能列表适配器"))
        templateList.add(Template(R.mipmap.main_icon_6, "图片查看器", "图片查看"))
        return templateList
    }
}
