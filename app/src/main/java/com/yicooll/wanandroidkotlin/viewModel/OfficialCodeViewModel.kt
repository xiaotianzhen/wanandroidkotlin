package com.yicooll.wanandroidkotlin.viewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.yicooll.wanandroidkotlin.entity.ModelOfficialCodeCategory
import com.yicooll.wanandroidkotlin.repository.OfficialCodeRepository

class OfficialCodeViewModel(application: Application) : AndroidViewModel(application) {

    private var officialCodeCategoryLiveData: MutableLiveData<ModelOfficialCodeCategory>? = null
    private var repository: OfficialCodeRepository? = null
    fun getOfficialCodeCategoryLiveData(): MutableLiveData<ModelOfficialCodeCategory>? {
        return officialCodeCategoryLiveData
    }


    fun getOfficialCodeCategory() {
        repository = OfficialCodeRepository()
        repository?.getOfficialCodeCategory()
        officialCodeCategoryLiveData = repository?.getOfficialCodeCategoryLiveData()
    }
}