package com.yicooll.wanandroidkotlin.utils

import java.text.SimpleDateFormat

class Util {

    companion object {

        fun formatData(time: Long?): String{
            if (time != null) {
                val sf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                return sf.format(time)
            }

            return ""
        }

        fun formatData(time: Long?, pattern: String): String {
            if (time != null) {
                val sf = SimpleDateFormat(pattern)
                return sf.format(time)
            }
            return ""
        }
    }
}