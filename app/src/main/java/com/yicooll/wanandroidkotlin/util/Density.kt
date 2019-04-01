package com.yicooll.wanandroidkotlin.util

import android.app.Activity
import android.app.Application
import android.content.ComponentCallbacks
import android.content.res.Configuration
import android.util.DisplayMetrics

object Density {

    private var sNoncompatDensity: Float = 0.toFloat()
    private var sNoncompatScaledDensity: Float = 0.toFloat()

    private var oldDensity = -1f
    private var oldDensityDpi = -1
    private var oldScaledDensity = -1f

    fun setCustomDensity(activity: Activity,application:Application ){
      var appDisplayMetrics:DisplayMetrics=application.resources.displayMetrics

        if(sNoncompatDensity==0.toFloat()){
            sNoncompatDensity=appDisplayMetrics.density
            sNoncompatScaledDensity=appDisplayMetrics.scaledDensity

            application.registerComponentCallbacks(object :ComponentCallbacks{
                override fun onLowMemory() {

                }

                override fun onConfigurationChanged(newConfig: Configuration?) {
                    if (newConfig != null && newConfig.fontScale > 0) {
                        sNoncompatScaledDensity = application.resources.displayMetrics.scaledDensity
                    }
                }
            })
            val targetDensity = appDisplayMetrics.widthPixels.toFloat() / 384
            val targetScaledDensity = targetDensity * (sNoncompatScaledDensity / sNoncompatDensity)
            val targetDensityDpi = (160 * targetDensity).toInt()
            appDisplayMetrics.density = targetDensity
            appDisplayMetrics.scaledDensity = targetScaledDensity
            appDisplayMetrics.densityDpi = targetDensityDpi

            val activityDisplayMetrics = activity.resources.displayMetrics
            activityDisplayMetrics.density = targetDensity
            activityDisplayMetrics.scaledDensity = targetScaledDensity
            activityDisplayMetrics.densityDpi = targetDensityDpi
        }
    }


    fun resetDensity(activity: Activity,application:Application ){
        var appDisplayMetrics:DisplayMetrics=application.resources.displayMetrics
        if(oldDensity==-1f){
            oldDensity=appDisplayMetrics.density
        }
        if(oldDensityDpi==-1){
            oldDensityDpi=appDisplayMetrics.densityDpi
        }
        if(oldScaledDensity==-1f){
            oldScaledDensity=appDisplayMetrics.scaledDensity
        }

        if(sNoncompatDensity==0.toFloat()){
            sNoncompatDensity=appDisplayMetrics.density
            sNoncompatScaledDensity=appDisplayMetrics.scaledDensity

            application.registerComponentCallbacks(object :ComponentCallbacks{
                override fun onLowMemory() {

                }

                override fun onConfigurationChanged(newConfig: Configuration?) {
                    if (newConfig != null && newConfig.fontScale > 0) {
                        sNoncompatScaledDensity = application.resources.displayMetrics.scaledDensity
                        oldScaledDensity *= newConfig.fontScale
                    }
                }
            })


            val activityDisplayMetrics = activity.resources.displayMetrics
            activityDisplayMetrics.density = oldDensity
            activityDisplayMetrics.scaledDensity = oldScaledDensity
            activityDisplayMetrics.densityDpi = oldDensityDpi
        }
    }

}