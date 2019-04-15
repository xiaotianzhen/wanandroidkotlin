package com.yicooll.wanandroidkotlin.ui.adapter

import android.view.View
import android.view.WindowId
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.entity.ModelProjectCategory

class ProjectCategoryAdapter(layoutId: Int, datas: List<ModelProjectCategory.Data>) : BaseQuickAdapter<ModelProjectCategory.Data, BaseViewHolder>(layoutId, datas) {


    private var currentPosition = 0
    private var listener: OnCustomerItemClickListener? = null

    fun setListener(listener: OnCustomerItemClickListener) {
        this.listener = listener
    }

    override fun convert(helper: BaseViewHolder?, item: ModelProjectCategory.Data?) {
        if (helper?.adapterPosition == currentPosition) {
            helper?.getView<TextView>(R.id.tv_category_name)?.setBackgroundResource(R.color.bg_main_color)
        } else {
            helper?.getView<TextView>(R.id.tv_category_name)?.setBackgroundResource(R.color.bg_white)
        }
        helper?.getView<TextView>(R.id.tv_category_name)?.text = item?.name

        helper?.getView<TextView>(R.id.tv_category_name)?.setOnClickListener {
            currentPosition = helper?.adapterPosition
            if (listener != null) {
                listener!!.onItemClick(it,helper?.adapterPosition)
            }
            notifyDataSetChanged()
        }
    }

    fun itemState(position:Int){
        currentPosition=position
        notifyDataSetChanged()
    }


    interface OnCustomerItemClickListener {
        fun onItemClick(view: View,position : Int)
    }

}