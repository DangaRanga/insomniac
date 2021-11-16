package com.example.insomniac.ui.startscreens

import android.os.Bundle
import android.annotation.SuppressLint
import android.widget.Button
import android.view.View
import android.view.MotionEvent
import android.content.Intent
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.insomniac.R

class SignupPage1Activity: AppCompatActivity() {
    var username = "";
    var gender = "";
    var age = 0;

    @SuppressLint("ClickableViewAccessibility")
    private val startTouchListener = View.OnTouchListener { view, motionEvent ->
        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                val intent = Intent(this, SignupPage2Activity::class.java).apply {}
//                intent.putExtra("usernme", this.username)
//                intent.putExtra("gender", this.gender)
//                intent.putExtra("age", this.age)
                startActivity(intent);
            }
            MotionEvent.ACTION_UP -> {
                val intent = Intent(this, SignupPage2Activity::class.java).apply {}
//                intent.putExtra("usernme", this.username)
//                intent.putExtra("gender", this.gender)
//                intent.putExtra("age", this.age)
                startActivity(intent);
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_page1)
//        setupScreen()
        findViewById<Button>(R.id.nextStep1).setOnTouchListener(startTouchListener)
    }

    private fun setupScreen() {
        this.username = findViewById<EditText>(R.id.editPersonName).toString();
        this.gender = findViewById<EditText>(R.id.editGender).toString();
        this.age = Integer.parseInt(findViewById<EditText>(R.id.editAge).toString());

    }
}