package com.yicooll.wanandroidkotlin.ui.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.entity.ModelOfficialCodeList

class OfficialCodeAdapter(layoutId:Int, data: ArrayList<ModelOfficialCodeList.Data.DataX>):BaseQuickAdapter<ModelOfficialCodeList.Data.DataX,BaseViewHolder>(layoutId,data)  {

    override fun convert(helper: BaseViewHolder?, item: ModelOfficialCodeList.Data.DataX?) {
        helper?.getView<TextView>(R.id.tv_item_name)?.text=item?.title
        if((helper?.adapterPosition!!+1)%2==0){
            helper?.getView<TextView>(R.id.tv_item_name).setBackgroundResource(R.color.bg_lose_yellow)
        }else{
            helper?.getView<TextView>(R.id.tv_item_name).setBackgroundResource(R.color.bg_lose_blue)
        }
    }
}