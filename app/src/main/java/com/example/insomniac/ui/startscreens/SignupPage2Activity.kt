package com.example.insomniac.ui.startscreens

import android.os.Bundle
import android.annotation.SuppressLint
import android.widget.Button
import android.view.View
import android.view.MotionEvent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.insomniac.R

class SignupPage2Activity: AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    private val startTouchListener = View.OnTouchListener { view, motionEvent ->
        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                val intent = Intent(this, SignupPage3Activity::class.java).apply {}
                startActivity(intent);
            }
            MotionEvent.ACTION_UP -> {
                val intent = Intent(this, SignupPage3Activity::class.java).apply {}
                startActivity(intent);
            }
        }
        false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_page2)
        findViewById<Button>(R.id.nextStep2).setOnTouchListener(startTouchListener)
    }
}