package com.padc.padcanimations.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.padc.padcanimations.databinding.ActivityViewGroupAnimationsBinding
import com.padc.padcanimations.extensions.show
import com.padc.padcanimations.extensions.toggleVisibility

class ViewGroupAnimationsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewGroupAnimationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewGroupAnimationsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //ViewGroup Animation
        binding.btnFirst.setOnClickListener {
            binding.btnFirst.toggleVisibility()
        }

        binding.btnSecond.setOnClickListener {
            binding.btnSecond.toggleVisibility()
        }

        binding.btnThird.setOnClickListener {
            binding.btnThird.toggleVisibility()
        }

        binding.btnReset.setOnClickListener {
            binding.btnFirst.show()
            binding.btnSecond.show()
            binding.btnThird.show()
        }
    }

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context,ViewGroupAnimationsActivity::class.java)
        }
    }
}