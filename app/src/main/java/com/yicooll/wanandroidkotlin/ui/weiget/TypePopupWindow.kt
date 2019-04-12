package com.yicooll.wanandroidkotlin.ui.weiget

import android.content.Context
import android.widget.PopupWindow
import android.graphics.drawable.ColorDrawable
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.yicooll.wanandroidkotlin.EventAction
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.entity.Event
import com.yicooll.wanandroidkotlin.ui.adapter.ProjectCategoryAdapter
import de.greenrobot.event.EventBus


class TypePopupWindow(context: Context, adapter: ProjectCategoryAdapter) {

    init {
        //准备PopupWindow的布局View
        val popupView = LayoutInflater.from(context).inflate(R.layout.wan_pop_project_pop, null)
        //初始化一个PopupWindow，width和height都是WRAP_CONTENT
        val popupWindow = PopupWindow(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        //设置PopupWindow的视图内容
        popupWindow.contentView = popupView

        var rvCategory = popupView.findViewById<RecyclerView>(R.id.rv_category)
        rvCategory.adapter = adapter
        rvCategory.layoutManager = LinearLayoutManager(context)

        popupView.findViewById<View>(R.id.view).setOnClickListener {
            popupWindow.dismiss()
        }

        adapter.setListener(object : ProjectCategoryAdapter.OnCustomerItemClickListener {
            override fun onItemClick(view: View, id: Int) {
                EventBus.getDefault().post(Event(EventAction.PROJECT_CATEGORY, id))
                popupWindow.dismiss()
            }
        })


        //点击空白区域PopupWindow消失，这里必须先设置setBackgroundDrawable，否则点击无反应
        popupWindow.setBackgroundDrawable(ColorDrawable(0x00000000))
        popupWindow.isOutsideTouchable = true
        //设置PopupWindow动画
        popupWindow.animationStyle = R.style.ActionSheetDialogAnimation
        //设置是否允许PopupWindow的范围超过屏幕范围
        popupWindow.isClippingEnabled = true
        //设置PopupWindow消失监听
        popupWindow.setOnDismissListener { }
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
        popupWindow.update()
        //PopupWindow在targetView下方弹出
        //popupWindow.showAsDropDown(targetView)
    }

}