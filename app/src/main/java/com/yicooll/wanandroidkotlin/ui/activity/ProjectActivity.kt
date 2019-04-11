package com.yicooll.wanandroidkotlin.ui.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.base.BaseActivity
import com.yicooll.wanandroidkotlin.entity.ModelProjectList
import com.yicooll.wanandroidkotlin.ui.adapter.ProjectAdapter
import com.yicooll.wanandroidkotlin.viewModel.ProjectViewModel
import kotlinx.android.synthetic.main.activity_project.*
import kotlinx.android.synthetic.main.include_noback_toolbar.*

class ProjectActivity : BaseActivity() {

    private var vm: ProjectViewModel? = null
    private var pageNum = 1
    private var projectList = ArrayList<ModelProjectList.Data.Data>()
    private var projectAdapter: ProjectAdapter? = null
    private var typeId = 0

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_project
    }

    override fun initView() {
        var llMenu = getHeadMenu()
        layoutInflater.inflate(R.layout.include_base_toolbar, llMenu)
        tv_menu_center.text = "项目"


        projectAdapter = ProjectAdapter(R.layout.adapter_project_list, projectList)
        rv_project.adapter = projectAdapter
        rv_project.layoutManager = LinearLayoutManager(this)
    }

    override fun initEvent() {
        vm = ViewModelProviders.of(this).get(ProjectViewModel::class.java)
        vm?.getProjectCategory()


        vm?.getProjectCategoryLiveData()?.observe(this, Observer {
            it?.let { it1 ->
                typeId = it1.data[0].id
                vm?.getProjectByType(typeId, pageNum)
            }
            setProjectList()
        })


        projectAdapter?.setOnLoadMoreListener({
            vm?.getProjectByType(typeId, ++pageNum)
        }, rv_project)
    }

    private fun setProjectList() {
        vm?.getProjectListLiveData()?.observe(this, Observer {
            if (pageNum == 1) {
                projectList.clear()
            }
            it?.let { it1 ->
                projectList.addAll(it1.data.datas)
                projectAdapter?.notifyDataSetChanged()
                if (it1.data.datas.size < 15) {
                    projectAdapter?.loadMoreEnd()
                } else {
                    projectAdapter?.loadMoreComplete()
                }
            }
        })
    }
}
