package com.yicooll.wanandroidkotlin.ui.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.entity.ModelSystemCatogry

class ArticalSystemChildrenAdapter(layoutResId: Int, data: ArrayList<ModelSystemCatogry.Data.Children>) : BaseQuickAdapter<ModelSystemCatogry.Data.Children, BaseViewHolder>(layoutResId, data) {

    private var currentPosition = -1
    private var onItemClickListener: OnItemClickListener? = null

    fun setCustomerItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    override fun convert(helper: BaseViewHolder?, item:ModelSystemCatogry.Data.Children?) {
        if (helper?.adapterPosition == currentPosition) {
            helper?.getView<TextView>(R.id.tv_category)?.setBackgroundResource(R.color.bg_yellow)
        } else {
            helper?.getView<TextView>(R.id.tv_category)?.setBackgroundResource(R.color.bg_white)
        }
        helper?.getView<TextView>(R.id.tv_category)?.text = item?.name

        helper?.getView<TextView>(R.id.tv_category)?.setOnClickListener {
            currentPosition = helper.adapterPosition
            if (onItemClickListener != null) {
                onItemClickListener?.onItemClick(currentPosition)
            }
            notifyDataSetChanged()
        }
    }


    fun update() {
        currentPosition = -1
        notifyDataSetChanged()
    }

    interface OnItemClickListener {

        fun onItemClick(position: Int)
    }
}