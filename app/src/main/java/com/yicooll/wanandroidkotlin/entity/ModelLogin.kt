package com.yicooll.wanandroidkotlin.entity

data class ModelLogin(
    val `data`: Data,
    val errorCode: Int,
    val errorMsg: String
) {
    data class Data(
        val chapterTops: List<Any>,
        val collectIds: List<Int>,
        val email: String,
        val icon: String,
        val id: Int,
        val password: String,
        val token: String,
        val type: Int,
        val username: String
    )
}