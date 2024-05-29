package com.elvin.simpleapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.elvin.simpleapp.databinding.ActivitySplashBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivitySplashBinding
private val handler: Handler = Handler(Looper.getMainLooper())

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val logo = binding.imageView
        val slideAnimation = android.view.animation.AnimationUtils.loadAnimation(this, com.elvin.simpleapp.R.anim.slide)

        logo.startAnimation(slideAnimation)

        handler.postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}