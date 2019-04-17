package com.yicooll.wanandroidkotlin.ui.adapter

import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.entity.Template

class WeigetAdapter(layoutId: Int, datas: ArrayList<Template>) : BaseQuickAdapter<Template, BaseViewHolder>(layoutId, datas) {

    override fun convert(helper: BaseViewHolder?, item: Template?) {
         helper?.getView<TextView>(R.id.tv_title)?.text=item?.templateName
         helper?.getView<ImageView>(R.id.iv_icon)?.setBackgroundResource(item?.rsId!!)
         helper?.getView<TextView>(R.id.tv_describe)?.text=item?.describe
    }
}