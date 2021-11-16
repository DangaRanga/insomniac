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

class SignupPage2Activity: AppCompatActivity() {
    var feet = 0;
    var inches = 0;
    var weight = 0;
    var fitness = "";

    @SuppressLint("ClickableViewAccessibility")
    private val startTouchListener = View.OnTouchListener { view, motionEvent ->
        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                val intent = Intent(this, SignupPage3Activity::class.java).apply {}
//                intent.putExtra("feet", this.feet)
//                intent.putExtra("inches", this.inches)
//                intent.putExtra("weight", this.weight)
//                intent.putExtra("fitness", this.fitness)
                startActivity(intent);
            }
            MotionEvent.ACTION_UP -> {
                val intent = Intent(this, SignupPage3Activity::class.java).apply {}
//                intent.putExtra("feet", this.feet)
//                intent.putExtra("inches", this.inches)
//                intent.putExtra("weight", this.weight)
//                intent.putExtra("fitness", this.fitness)
                startActivity(intent);
            }
        }
        false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_page2)
//        setupScreen()
        findViewById<Button>(R.id.nextStep2).setOnTouchListener(startTouchListener)
    }

    private fun setupScreen() {
        this.feet = Integer.parseInt(findViewById<EditText>(R.id.editFeet).toString());
        this.inches = Integer.parseInt(findViewById<EditText>(R.id.editInches).toString());
        this.weight = Integer.parseInt(findViewById<EditText>(R.id.editWeight).toString());
        this.fitness = findViewById<EditText>(R.id.editFitness).toString();
    }
}