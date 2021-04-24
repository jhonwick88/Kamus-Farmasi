package com.pintarmedia.kamusfarmasi

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        val topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        val bottomAnmation = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        //logo.animation(topAnimation)
        logoSplash.startAnimation(topAnimation);
        titleSplash.startAnimation(bottomAnmation);
        val splashTimeOut = 4000
        val homeInten = Intent(this,MainActivity::class.java)

        Handler().postDelayed({
            startActivity(homeInten)
            finish()
        },splashTimeOut.toLong())

    }
}