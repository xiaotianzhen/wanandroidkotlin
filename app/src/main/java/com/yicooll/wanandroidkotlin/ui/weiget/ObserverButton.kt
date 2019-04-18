package com.yicooll.wanandroidkotlin.ui.weiget

import android.content.Context
import android.graphics.Color
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.EditText
import android.widget.TextView
import com.yicooll.wanandroidkotlin.R
import java.util.ArrayList

class ObserverButton(context: Context, attrs: AttributeSet) : TextView(context, attrs) {
    private val editTextList = ArrayList<EditText>()

    private var canPress: Boolean = false
    private var defaultBg = Color.GRAY
    private var pressBg = Color.BLUE
    private var defaultTextColor = Color.WHITE
    private var pressTextColor = Color.WHITE
    private var defaultBgRes: Int = 0
    private var pressBgRes: Int = 0

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.ObserverButton)
        defaultBg = a.getColor(R.styleable.ObserverButton_defaultBgColor, defaultBg)
        pressBg = a.getColor(R.styleable.ObserverButton_pressBgColor, pressBg)
        defaultTextColor = a.getColor(R.styleable.ObserverButton_defaultTextColor, defaultTextColor)
        pressTextColor = a.getColor(R.styleable.ObserverButton_pressTextColor, pressTextColor)
        defaultBgRes = a.getResourceId(R.styleable.ObserverButton_defaultBgResource, 0)
        pressBgRes = a.getResourceId(R.styleable.ObserverButton_pressBgResource, 0)
        a.recycle()
        initbtn()
    }


    fun observer(vararg editTexts: EditText) {
        for (editText in editTexts) {
            editText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {
                    checkEditText()
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }
            })
            editTextList.add(editText)
        }
    }


    fun checkEditText() {
        canPress = true
        for (et in editTextList) {
            if (TextUtils.isEmpty(et.text.trim())) {
                canPress = false
                break
            }
        }
        initbtn()
    }

    private fun initbtn() {
        if (canPress) {
            setTextColor(pressTextColor)
            if (pressBgRes != 0) {
                setBackgroundResource(pressBgRes)
            } else {
                setBackgroundColor(pressBg)
            }
            isEnabled = true
        } else {
            setTextColor(defaultTextColor)
            if (pressBgRes != 0) {
                setBackgroundResource(defaultBgRes)
            } else {
                setBackgroundColor(defaultBg)
            }
            isEnabled = false
        }
    }
}