package com.yicooll.wanandroidkotlin.ui.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.entity.ModelSearch

class SearchAdapter(layoutId: Int, datas: List<ModelSearch.Data.Data>) : BaseQuickAdapter<ModelSearch.Data.Data, BaseViewHolder>(layoutId, datas) {

    override fun convert(helper: BaseViewHolder?, item: ModelSearch.Data.Data?) {
        helper?.setText(R.id.tv_author, item?.author)
        helper?.setText(R.id.tv_title, item?.title)
        helper?.setText(R.id.tv_type1, item?.chapterName)
        helper?.setText(R.id.tv_type2, item?.superChapterName)
        helper?.setText(R.id.tv_date, item?.niceDate)
        if (item?.zan == 0) {
            helper?.getView<ImageView>(R.id.iv_collection)?.setImageResource(R.mipmap.icon_collection)
        } else if (item?.zan == 1) {
            helper?.getView<ImageView>(R.id.iv_collection)?.setImageResource(R.mipmap.icon_collectioned)
        }
    }
}
