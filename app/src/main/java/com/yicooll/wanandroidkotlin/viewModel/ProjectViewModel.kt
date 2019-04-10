package com.yicooll.wanandroidkotlin.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.entity.ModelProjectCategory
import com.yicooll.wanandroidkotlin.entity.ModelProjectList
import com.yicooll.wanandroidkotlin.repository.ProjectRepository

class ProjectViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: ProjectRepository? = null
    private var projectListLiveData: MutableLiveData<ModelProjectList>? = null
    private var projectCategoryLiveData: MutableLiveData<ModelProjectCategory>? = null


    fun getProjectListLiveData(): MutableLiveData<ModelProjectList>? {
        return projectListLiveData
    }

    fun getProjectCategoryLiveData(): MutableLiveData<ModelProjectCategory>? {
        return projectCategoryLiveData
    }

    fun getProjectByType(cid: Int, pageNum: Int) {
        repository?.getProjectByType(cid, pageNum)
        projectListLiveData = repository?.getProjectListLiveData()
    }

    fun getProjectCategory() {
        repository = ProjectRepository()
        repository?.getProjectCategory()
        projectCategoryLiveData = repository?.getProjectCategoryLiveData()
    }
}