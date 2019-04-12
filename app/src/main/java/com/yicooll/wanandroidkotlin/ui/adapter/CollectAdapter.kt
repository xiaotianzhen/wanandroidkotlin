package com.yicooll.wanandroidkotlin.ui.adapter

import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.entity.ModelCollect
import com.yicooll.wanandroidkotlin.utils.Util

class CollectAdapter(layoutId: Int, datas: List<ModelCollect.Data.Data>) : BaseQuickAdapter<ModelCollect.Data.Data, BaseViewHolder>(layoutId, datas) {
    override fun convert(helper: BaseViewHolder?, item: ModelCollect.Data.Data?) {
        Glide.with(mContext).load(item?.envelopePic).into(helper?.getView(R.id.iv_img)!!)
        if (!item?.desc.equals("")) {
            helper?.getView<TextView>(R.id.tv_des)?.text = item?.desc
        } else {
            helper?.getView<TextView>(R.id.tv_des)?.text = item?.title
        }
        helper?.getView<TextView>(R.id.tv_author)?.text = "作者：" + item?.author
        helper?.getView<TextView>(R.id.tv_date)?.text = Util.formatData(item?.publishTime)
    }
}