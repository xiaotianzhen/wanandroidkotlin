package com.yicooll.wanandroidkotlin.ui.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.entity.ModelGoodsInfo

class ShopRecommentAdapter(layoutId:Int,datas:ArrayList<ModelGoodsInfo>):BaseQuickAdapter<ModelGoodsInfo,BaseViewHolder>(layoutId,datas){

    override fun convert(helper: BaseViewHolder?, item: ModelGoodsInfo?) {

        Glide.with(mContext).load(item?.goodsMasterImg).into(helper!!.getView<ImageView>(R.id.iv_goods))
        helper!!.setText(R.id.tv_goods_name,item?.goodsName)
        helper!!.setText(R.id.tv_goods_price,"￥"+item?.goodsPrice)
        helper!!.setText(R.id.tv_goods_old_price,"￥"+item?.goodsOldPrice)
    }

}