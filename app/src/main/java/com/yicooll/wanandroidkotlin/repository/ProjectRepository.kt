package com.yicooll.wanandroidkotlin.repository

import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.api_service.ProjectService
import com.yicooll.wanandroidkotlin.entity.ModelProjectCategory
import com.yicooll.wanandroidkotlin.entity.ModelProjectList
import com.yicooll.wanandroidkotlin.network.RetrofitUtil
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ProjectRepository {


    private var projectListLiveData = MutableLiveData<ModelProjectList>()
    private var projectCategoryLiveData = MutableLiveData<ModelProjectCategory>()

    fun getProjectListLiveData(): MutableLiveData<ModelProjectList> {
        return projectListLiveData
    }

    fun getProjectCategoryLiveData(): MutableLiveData<ModelProjectCategory> {
        return projectCategoryLiveData
    }


    fun getProjectByType(cid: Int, pageNum: Int) {
        val client = RetrofitUtil.getRetorfit()
        val service = client!!.create(ProjectService::class.java)
        val url = "project/list/$pageNum/json?cid=$cid"
        service.getProjectByType(url)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ModelProjectList> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable?) {
                    }

                    override fun onNext(value: ModelProjectList?) {
                        projectListLiveData.value = value
                    }

                    override fun onError(e: Throwable?) {
                        projectListLiveData.value = null
                    }

                })
    }

    fun getProjectCategory() {

        val client = RetrofitUtil.getRetorfit()
        val service = client!!.create(ProjectService::class.java)
        service.getProjectCategory()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ModelProjectCategory> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable?) {
                    }

                    override fun onNext(value: ModelProjectCategory?) {
                        projectCategoryLiveData.value = value
                    }

                    override fun onError(e: Throwable?) {
                        projectCategoryLiveData.value = null
                    }
                })
    }
}