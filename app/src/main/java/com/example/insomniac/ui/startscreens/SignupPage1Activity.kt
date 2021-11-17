package com.example.insomniac.ui.startscreens

import android.os.Bundle
import android.annotation.SuppressLint
import android.content.Context
import android.widget.Button
import android.view.View
import android.view.MotionEvent
import android.content.Intent
import android.util.Log
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText
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
                setupScreen()
                val intent = Intent(this, SignupPage2Activity::class.java).apply {}
                intent.putExtra("USERNAME", this.username)
                intent.putExtra("GENDER", this.gender)
                intent.putExtra("AGE", this.age)
                startActivity(intent);
            }
            MotionEvent.ACTION_UP -> {
                setupScreen()
                val intent = Intent(this, SignupPage2Activity::class.java).apply {}
                intent.putExtra("username", this.username)
                intent.putExtra("gender", this.gender)
                intent.putExtra("age", this.age)
                startActivity(intent);
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_page1)

        findViewById<Button>(R.id.nextStep1).setOnTouchListener(startTouchListener)
    }

    private fun setupScreen() {
        val tempUsername: EditText  = findViewById<EditText>(R.id.editPersonName);
        var tempGender:  EditText = findViewById<EditText>(R.id.editGender);
        var tempAge:  EditText = findViewById<EditText>(R.id.editAge);
        this.username = tempUsername.text.toString();
        this.gender = tempGender.text.toString();
        if(tempAge.text.toString().toInt() == null){
            this.age = 0
        }else{
            this.age = tempAge.text.toString().toInt();
        }

//        print(tempAge)

    }
}