package com.padc.padcanimations.activities

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import androidx.core.animation.addListener
import com.padc.padcanimations.R
import com.padc.padcanimations.databinding.ActivityViewAnimationBinding
import com.padc.padcanimations.extensions.addAnimationEndListener
import com.padc.padcanimations.extensions.hide
import com.padc.padcanimations.extensions.isShownOnScreen
import com.padc.padcanimations.extensions.show
import kotlin.math.hypot

class ViewAnimationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewAnimationBinding
    private val ANIMATION_DURATION = 4000L
    private var isTextViewVisible = true

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context,ViewAnimationActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewAnimationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvText.show()
        binding.progressIndicator.hide()
        binding.ivWallpaper.hide()
        binding.btnReveal.hide()

        binding.btnCircularRevealAnimation.setOnClickListener {
            createCircularRevealAnimation(binding.tvText)
            createImageAnimation()
        }
    }

    private fun createImageAnimation(){
        val cx = binding.ivWallpaper.width/2
        val cy = binding.ivWallpaper.height/2

        val initialRadius = hypot(cx.toDouble(),cy.toDouble()).toFloat()

        val anim = ViewAnimationUtils.createCircularReveal(
            binding.ivWallpaper,
            cx,
            cy,
            0f,
            initialRadius
        )

        anim.addListener(object : AnimatorListenerAdapter(){
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                binding.ivWallpaper.show()
            }
        })

        anim.start()
    }

    private fun createCircularRevealAnimation(view : View) {
        val cx = view.width/2
        val cy = view.height/2

        val initialRadius = hypot(cx.toDouble(),cy.toDouble()).toFloat()

        val anim = if (isTextViewVisible){
            ViewAnimationUtils.createCircularReveal(
                view,
                cx,
                cy,
                initialRadius,
                0f)
        } else {
            ViewAnimationUtils.createCircularReveal(
                view,
                cx,
                cy,
                0f,
                initialRadius)
        }

        anim.addListener(object : AnimatorListenerAdapter(){
            override fun onAnimationStart(animation: Animator) {
                super.onAnimationStart(animation)
                if (isTextViewVisible) {
                    view.show()
                }
            }
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                if (!isTextViewVisible){
                    view.hide()
                }
            }
        })

        isTextViewVisible = !isTextViewVisible
        anim.start()
    }

    override fun onStart() {
        super.onStart()
       // createCrossFadeAnimation()
    }

    private fun createCrossFadeAnimation(){
        binding.tvText.apply {
            show()
            alpha = 0.0f

            animate()
                .alpha(1.0f)
                .setDuration(ANIMATION_DURATION)
                .setListener(null)

        }

        binding.progressIndicator.apply {
            animate()
                .alpha(0.0f)
                .setDuration(ANIMATION_DURATION)
                .addAnimationEndListener { binding.progressIndicator.hide() }
        }
    }

}