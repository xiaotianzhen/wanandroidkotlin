package com.yicooll.wanandroidkotlin.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.entity.ModelOfficialCodeCategory
import com.yicooll.wanandroidkotlin.entity.ModelOfficialCodeList
import com.yicooll.wanandroidkotlin.repository.OfficialCodeRepository

class OfficialCodeViewModel(application: Application) : AndroidViewModel(application) {

    private var officialCodeCategoryLiveData: MutableLiveData<ModelOfficialCodeCategory>? = null
    private var repository: OfficialCodeRepository? = null
    private var officialCodeListLiveData:MutableLiveData<ModelOfficialCodeList>?=null

    init {
        repository = OfficialCodeRepository()
    }
    fun getOfficialCodeCategoryLiveData(): MutableLiveData<ModelOfficialCodeCategory>? {
        return officialCodeCategoryLiveData
    }

    fun getOfficialCodeListLiveData(): MutableLiveData<ModelOfficialCodeList>? {
        return officialCodeListLiveData
    }


    fun getOfficialCodeCategory() {
        repository?.getOfficialCodeCategory()
        officialCodeCategoryLiveData = repository?.getOfficialCodeCategoryLiveData()
    }

    fun getOfficialCodeList(id:Int,pageNum:Int){
        repository?.getOfficialCodeList(id,pageNum)
        officialCodeListLiveData=repository?.getOfficialCodeListLiveData()
    }
}