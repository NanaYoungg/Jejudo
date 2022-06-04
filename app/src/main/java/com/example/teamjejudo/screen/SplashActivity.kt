package com.example.teamjejudo.screen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.teamjejudo.MainActivity
import com.example.teamjejudo.R
import com.example.teamjejudo.databinding.ActivityMainBinding
import com.example.teamjejudo.databinding.ActivitySplashBinding

private const val SPLASH_VIEW_TIME: Long = 3000 //3초

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //이미지뷰에 GIF
        Glide.with(this).load(R.raw.travel_icon2).into(binding.ivSplash)

        //delay 를 위한 handler
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_VIEW_TIME)
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        //상태바 제거 풀스크린으로
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.activity_splash)
//
//        //이미지뷰에 GIF
//        val imageView: ImageView = findViewById(R.id.splash_gif_iv)
//        Glide.with(this).load(R.drawable.splash_beer_gif).into(imageView)
//
//        //delay를 위한 handler
//        Handler().postDelayed({
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
//        }, SPLASH_VIEW_TIME)
//    }
}