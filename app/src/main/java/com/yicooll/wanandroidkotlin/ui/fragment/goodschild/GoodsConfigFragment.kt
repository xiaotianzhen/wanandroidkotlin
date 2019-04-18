package com.yicooll.wanandroidkotlin.ui.fragment.goodschild

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseFragment
import com.yicooll.wanandroidkotlin.entity.GoodsConfigBean
import com.yicooll.wanandroidkotlin.ui.adapter.ShopConfigAdapter
import kotlinx.android.synthetic.main.fragment_goods_config.*


class GoodsConfigFragment : BaseFragment() {

    private val configData = ArrayList<GoodsConfigBean>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_goods_config, container, false)
    }

    override fun initView() {
    }

    override fun initEvent() {
        configData.clear()
        configData.add(GoodsConfigBean("品牌", "小米Mix 3"))
        configData.add(GoodsConfigBean("型号", "全面屏 小米Mix 3"))

        val adapter = ShopConfigAdapter(R.layout.adapter_market_of_goods_config_list, configData)
        rv_sku.adapter = adapter
        rv_sku.layoutManager = LinearLayoutManager(activity)
    }


}
