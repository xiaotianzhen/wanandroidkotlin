package com.yicooll.wanandroidkotlin.ui.weiget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View

class CircleView(context: Context, attr: AttributeSet?) : View(context, attr) {

    private var paint: Paint = Paint()
    private var color: Int = 0

    constructor(context: Context) : this(context,null) {}

    init {
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
        paint.isDither = true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var cx: Float = (width / 2).toFloat()
        canvas?.drawCircle(cx, cx, cx, paint)
    }

    fun changeColor(color: Int) {
        this.color = color
        paint.color = ContextCompat.getColor(context, color)
        invalidate()
    }

    fun getColor(): Int {
        return color
    }
}