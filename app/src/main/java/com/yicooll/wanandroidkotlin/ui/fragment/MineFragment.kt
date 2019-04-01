package com.yicooll.wanandroidkotlin.ui.fragment

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.yicooll.wanandroidkotlin.BR
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseFragment


/**
 * A simple [Fragment] subclass.
 *
 */
class MineFragment : BaseFragment() {


    override fun initViewAndEvent() {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater,R.layout.fragment_mine, container, false)
        binding.setVariable(BR.presenter,Presenter())
        return binding.root
    }

   inner class Presenter {

        fun toLoginClick(view: View) {
            showToast("点击了")
        }


    }

    companion object {
        val headUrl: String = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542110989472&di=e206dfdad3d1197025ddc03bca0b013c&imgtype=0&src=http%3A%2F%2Fwww.pig66.com%2Fuploadfile%2F2017%2F1209%2F20171209121323978.png"
    }
}
