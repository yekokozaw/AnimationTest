package com.padc.padcanimations.activities

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.padc.padcanimations.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val progressAnimator : ObjectAnimator by lazy {
        ObjectAnimator.ofInt(binding.progressBar,"progress",0,100).apply {
            duration = 3000
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpListener()

        progressAnimator.start()
        binding.btnText.setOnClickListener{
            //Value Animator
//            ValueAnimator.ofFloat(0.0f,500.0f).apply {
//                duration = 2000
//                addUpdateListener {
//                    binding.btnText.translationX = it.animatedValue as Float
//                }
//                start()
//
//            }
//            ValueAnimator.ofFloat(0.0f,500.0f).apply {
//                duration = 3000
//                addUpdateListener {
//                    binding.btnText.translationY = it.animatedValue as Float
//                }
//                start()
//            }

            /** Object Animator */
            val translateAnimator = ObjectAnimator.ofFloat(binding.btnText,"translationX",0.0f,500.0f).apply {
                duration = 2000
            }

            val translateYAnimator = ObjectAnimator.ofFloat(binding.btnText,"translationY",0.0f,500.0f).apply {
                duration = 2000
            }

            val fadeAnimator = ObjectAnimator.ofFloat(binding.btnText,"alpha",1.0f,0.1f).apply {
                duration = 2000
            }

            /** Animator Set */
//            AnimatorSet().apply {
//                play()
//                start()
//            }
        }
    }

    private fun setUpListener(){
        binding.btnViewAnimation.setOnClickListener {
            startActivity(ViewAnimationActivity.newIntent(this))
        }
        binding.btnPhysicsAnimation.setOnClickListener {
            startActivity(PhysicsBasedAnimationActivity.newIntent(this))
        }
        binding.btnViewGroupAnimation.setOnClickListener {
            startActivity(ViewGroupAnimationsActivity.newIntent(this))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        progressAnimator.cancel()
    }
}