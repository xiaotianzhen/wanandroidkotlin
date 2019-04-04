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
        const val BANNER_TURN: Long = 5000
    }
}