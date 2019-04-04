package com.yicooll.wanandroidkotlin.util

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.manager.BlurTransformation

class ImageUtils {


    companion object {

        /**
         * 高斯模糊图片
         */
        fun loadImageBlur(imageview: ImageView, url: String) {
            Glide.with(imageview.context)
                    .load(url)
                    .apply(RequestOptions.bitmapTransform(
                            BlurTransformation(imageview.context)))
                    .into(imageview)
        }

        fun loadImageCircle(imageview: ImageView, url: String) {
            if (TextUtils.isEmpty(url)) {
                return
            }

            Glide.with(imageview.context)
                    .load(url)
                    .apply(RequestOptions.circleCropTransform().placeholder(R.mipmap.ic_loading_image)
                            .error(ColorDrawable(Color.WHITE)).fallback(ColorDrawable(Color.RED))).into(imageview)
        }
    }

}