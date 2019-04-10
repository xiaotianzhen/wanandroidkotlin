package com.yicooll.wanandroidkotlin.ui.adapter

import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.entity.ModelProjectList
import com.yicooll.wanandroidkotlin.utils.Util

class ProjectAdapter(layoutId:Int, data:ArrayList<ModelProjectList.DataBean.DatasBean>) :BaseQuickAdapter<ModelProjectList.DataBean.DatasBean,BaseViewHolder>(layoutId,data) {

    override fun convert(helper: BaseViewHolder?, item: ModelProjectList.DataBean.DatasBean?) {
       Glide.with(mContext).load(item?.envelopePic).into(helper?.getView(R.id.iv_img)!!)
        helper?.getView<TextView>(R.id.tv_des)?.text=item?.desc
        helper?.getView<TextView>(R.id.tv_author)?.text="作者："+item?.author
        helper?.getView<TextView>(R.id.tv_date)?.text=Util.formatData(item?.publishTime)
    }
}