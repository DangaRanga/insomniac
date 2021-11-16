package com.example.insomniac

import android.content.Intent

import android.os.Bundle
import android.os.Handler

import androidx.appcompat.app.AppCompatActivity
import com.example.insomniac.ui.startscreens.SignupPage1Activity


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splahscreen)
        Handler().postDelayed(Runnable { //This method will be executed once the timer is over
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            finish()
        }, 2000)

    }
}