package com.yicooll.wanandroidkotlin.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.entity.GoodsConfigBean

class ShopConfigAdapter(layoutId:Int,datas:ArrayList<GoodsConfigBean>):BaseQuickAdapter<GoodsConfigBean,BaseViewHolder>(layoutId,datas) {
    override fun convert(helper: BaseViewHolder?, item: GoodsConfigBean?) {
        helper?.setText(R.id.tv_config_key,item?.name)
        helper?.setText(R.id.tv_config_value,item?.value)
    }
}