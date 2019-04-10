package com.yicooll.wanandroidkotlin.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseFragment

class OfficialCodeListFragment : BaseFragment() {


    companion object {

        fun newInstance(typeId: Int): OfficialCodeListFragment {
            val args = Bundle()
            args.putInt("typeId", typeId)
            val fragment = OfficialCodeListFragment()
            fragment.setArguments(args)
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_official_code_list, container, false)
    }

    override fun initView() {
    }

    override fun initEvent() {
    }

}
