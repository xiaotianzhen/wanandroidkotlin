package com.yicooll.wanandroidkotlin.ui.weiget

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.*
import android.widget.RelativeLayout
import com.yicooll.wanandroidkotlin.R
import com.yicooll.wanandroidkotlin.utils.Util

class LoadingView(context: Context, attr: AttributeSet) : RelativeLayout(context, attr) {

    private var mLeftView: CircleView
    private var mMiddleView: CircleView
    private var mRightView: CircleView
    private var translationDistance: Float = 20.toFloat()
    private val mDuration: Long = 500
    private var isStopAnimate = false

    init {
        translationDistance = Util.dpTopx(translationDistance.toInt()).toFloat()
        mLeftView = getCircleView()
        mLeftView.changeColor(R.color.circle_color)
        mMiddleView = getCircleView()
        mMiddleView.changeColor(R.color.rect_color)
        mRightView = getCircleView()
        mRightView.changeColor(R.color.triangle_color)

        addView(mLeftView)
        addView(mMiddleView)
        addView(mRightView)

        //动画延迟开始（防止界面创建慢，导致动画已经执行）
        postDelayed({
            startExpandAnimation()
        }, 500)

    }

    private fun startExpandAnimation() {
        if (isStopAnimate) {
            return
        }
        val leftAnimator = ObjectAnimator.ofFloat(mLeftView, "translationX", 0.toFloat(), -translationDistance)
        val rightAnimator = ObjectAnimator.ofFloat(mRightView, "translationX", 0.toFloat(), translationDistance)
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(leftAnimator, rightAnimator)
        animatorSet.duration = mDuration
        animatorSet.interpolator = DecelerateInterpolator()
        animatorSet.start()

        animatorSet.addListener(object : AnimatorListenerAdapter() {

            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)

                startCollapseAnimation()
            }
        })

    }

    private fun startCollapseAnimation() {

        if (isStopAnimate) {
            return
        }
        val leftAnimator = ObjectAnimator.ofFloat(mLeftView, "translationX", -translationDistance, 0.toFloat())
        val rightAnimator = ObjectAnimator.ofFloat(mRightView, "translationX", translationDistance, 0.toFloat())
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(leftAnimator, rightAnimator)
        animatorSet.duration = mDuration
        animatorSet.interpolator = AccelerateInterpolator()
        animatorSet.start()

        animatorSet.addListener(object : AnimatorListenerAdapter() {

            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                //获取三种颜色
                val leftColor = mLeftView.getColor()
                val middleColor = mMiddleView.getColor()
                val rightColor = mRightView.getColor()

                mLeftView.changeColor(rightColor)
                mMiddleView.changeColor(leftColor)
                mRightView.changeColor(middleColor)
                startExpandAnimation()
            }
        })
    }

    private fun getCircleView(): CircleView {

        var lp = RelativeLayout.LayoutParams(Util.dpTopx(10), Util.dpTopx(10))
        lp.addRule(CENTER_IN_PARENT)
        val circleView = CircleView(context)
        circleView.layoutParams = lp
        return circleView
    }

    override fun setVisibility(visibility: Int) {
        super.setVisibility(visibility)

        if (visibility == View.GONE) {
            isStopAnimate = true
        }
        if (visibility == View.VISIBLE) {
            isStopAnimate = false
            startExpandAnimation()
        }
    }
}