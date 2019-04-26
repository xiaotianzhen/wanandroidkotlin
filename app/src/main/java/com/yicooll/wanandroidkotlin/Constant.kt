package com.yicooll.wanandroidkotlin

class Constant {

    interface buildConfig {
        companion object {
            /* 是否是debug模式  loghelper*/
            val isDebug = App.getInstance()?.resources?.getBoolean(R.bool.is_debug)
        }
    }

    companion object {
        const val appName = "wanandroid"
        const val BANNER_TURN: Long = 3000
        const val ONE_PAGE_COUNT = 20
        const val NETWORK_ERROR = "网络异常"
        const val FRESH_CODE = 1000   //刷新的code
        const val LOADING_DELAYED:Long = 800   //加载动画时间
    }
}