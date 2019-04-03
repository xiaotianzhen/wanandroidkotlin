package com.yicooll.wanandroidkotlin.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

object WeigetBindUtil {

    @BindingAdapter("url")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String?) {
        //kotlin判空处理的两种方式
        /*  if(url!=null){
             Glide.with(imageView.context).load(url).into(imageView)
         }*/
        url.let {
            Glide.with(imageView.context).load(url).into(imageView)
        }
    }
}