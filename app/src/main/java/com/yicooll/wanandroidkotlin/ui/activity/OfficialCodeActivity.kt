package com.yicooll.wanandroidkotlin.ui.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseActivity
import com.yicooll.wanandroidkotlin.entity.ModelOfficialCodeCategory
import com.yicooll.wanandroidkotlin.ui.fragment.OfficialCodeListFragment
import com.yicooll.wanandroidkotlin.viewModel.OfficialCodeViewModel
import kotlinx.android.synthetic.main.activity_official_code.*
import kotlinx.android.synthetic.main.include_noback_toolbar.*

class OfficialCodeActivity : BaseActivity() {


    private var vm: OfficialCodeViewModel? = null
    private var officialCodeCategory = ArrayList<ModelOfficialCodeCategory.Data>()
    private var fragmentList = ArrayList<Fragment>()
    private var adapter: FragmentPagerAdapter? = null

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_official_code
    }

    override fun initView() {
        var llMenu = getHeadMenu()
        layoutInflater.inflate(R.layout.include_base_toolbar, llMenu)
        tv_menu_center.text = "公众号"
        adapter = FragmentPagerAdapter(supportFragmentManager)
        viewpager.adapter = adapter
        tab_layout.setupWithViewPager(viewpager)

    }

    override fun initEvent() {
        vm = ViewModelProviders.of(this).get(OfficialCodeViewModel::class.java)
        vm?.getOfficialCodeCategory()
        vm?.getOfficialCodeCategoryLiveData()?.observe(this, Observer {

            it?.let { it1 ->
                officialCodeCategory.clear()
                fragmentList.clear()
                officialCodeCategory.addAll(it1.data)
                for (index in it1.data.indices) {
                    val fragment = OfficialCodeListFragment.newInstance(it1.data[index].id)
                    fragmentList.add(fragment)
                }
                adapter?.notifyDataSetChanged()
            }
        })

    }

    inner class FragmentPagerAdapter(fm: FragmentManager) : android.support.v4.app.FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return officialCodeCategory[position].name
        }

    }

}
