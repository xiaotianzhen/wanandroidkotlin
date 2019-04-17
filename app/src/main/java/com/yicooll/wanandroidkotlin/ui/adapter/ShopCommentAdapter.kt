package com.yicooll.wanandroidkotlin.ui.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.entity.ModelGoodsComment

class ShopCommentAdapter(layoutId: Int, datas: ArrayList<ModelGoodsComment>) : BaseQuickAdapter<ModelGoodsComment, BaseViewHolder>(layoutId, datas) {

    override fun convert(helper: BaseViewHolder?, item: ModelGoodsComment?) {

        Glide.with(mContext).load(item?.userHead).into(helper!!.getView<ImageView>(R.id.iv_head))
        helper?.setText(R.id.tv_name, item?.username)
        helper?.setText(R.id.tv_comment, item?.comment)
    }
}