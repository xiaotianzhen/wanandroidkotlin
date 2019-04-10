package com.yicooll.wanandroidkotlin.utils

import android.content.Context
import com.yicooll.wanandroidkotlin.Constant


class PreferenceHelper {

    companion object {
       private val PREFERENCE_NAME= Constant.appName


        fun putString(context: Context,key:String,value:String){
            val sp=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
            val editor= sp.edit()
            editor.putString(key,value)
            editor.commit()
        }

        fun putInt(context: Context,key:String,value:Int){
            val sp=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
            val editor= sp.edit()
            editor.putInt(key,value)
            editor.commit()
        }

        fun putBoolean(context: Context,key:String,value:Boolean){
            val sp=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
            val editor= sp.edit()
            editor.putBoolean(key,value)
            editor.commit()
        }

        fun putFloat(context: Context,key:String,value:Float){
            val sp=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
            val editor= sp.edit()
            editor.putFloat(key,value)
            editor.commit()
        }

        fun putLong(context: Context,key:String,value:Long){
            val sp=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
            val editor= sp.edit()
            editor.putLong(key,value)
            editor.commit()
        }


        fun getString(context: Context,key:String,defaultValue:String):String{
            val sp=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
            return sp.getString(key,defaultValue)
        }

        fun getInt(context: Context,key:String,defaultValue:Int):Int{
            val sp=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
            return sp.getInt(key,defaultValue)
        }

        fun getBoolean(context: Context,key:String,defaultValue:Boolean):Boolean{
            val sp=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
            return sp.getBoolean(key,defaultValue)
        }

        fun getFloat(context: Context,key:String,defaultValue:Float):Float{
            val sp=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
            return sp.getFloat(key,defaultValue)
        }

        fun getLong(context: Context,key:String,defaultValue:Long):Long{
            val sp=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
            return sp.getLong(key,defaultValue)
        }


        fun getString(context: Context,key:String):String{
            val sp=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
            return sp.getString(key,null)
        }

        fun getInt(context: Context,key:String):Int{
            val sp=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
            return sp.getInt(key,-1)
        }

        fun getBoolean(context: Context,key:String):Boolean{
            val sp=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
            return sp.getBoolean(key,false)
        }

        fun getFloat(context: Context,key:String):Float{
            val sp=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
            return sp.getFloat(key, (-1).toFloat())
        }

        fun getLong(context: Context,key:String):Long{
            val sp=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)
            return sp.getLong(key,-1)
        }

    }
}