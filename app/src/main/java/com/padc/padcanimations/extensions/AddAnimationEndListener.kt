package com.padc.padcanimations.extensions

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.view.ViewPropertyAnimator
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener

fun ViewPropertyAnimator.addAnimationEndListener(onAnimationEnd: () -> Unit){
    setListener(object : AnimatorListener{
        override fun onAnimationStart(animation: Animator) {

        }

        override fun onAnimationEnd(animation: Animator) {
            onAnimationEnd.invoke()
        }

        override fun onAnimationCancel(animation: Animator) {

        }

        override fun onAnimationRepeat(animation: Animator) {

        }


    })
}