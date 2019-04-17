package com.yicooll.wanandroidkotlin.entity

data class ModelGoodsInfo(val goodsId: String, val goodsName: String, val goodsMasterImg: String, val goodsPrice: String,
                          val goodsOldPrice: String, val vendorId: String, val praiseRate: String, val commentCount: String,
                          val num: Int, val checked: Boolean, val goodsHeadImg: List<String>?) {
}