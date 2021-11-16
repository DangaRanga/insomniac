package com.example.insomniac.ui.startscreens

import android.os.Bundle
import android.annotation.SuppressLint
import android.widget.Button
import android.view.View
import android.view.MotionEvent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.insomniac.R
import com.example.insomniac.ui.dashboard.DashboardStartActivity

class SignupPage3Activity: AppCompatActivity() {
    var username: String = "";
    var gender: String = "";
    var age: Int = 0;

    var feet: Int = 0;
    var inches: Int = 0;
    var weight: Int = 0;
    var fitness: String = "";

    var insomnia: Boolean = false;
    var sleepApnea: Boolean = false;
    var narcolepsy: Boolean = false;

    @SuppressLint("ClickableViewAccessibility")
    private val startTouchListener = View.OnTouchListener { view, motionEvent ->
        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                val intent = Intent(this, DashboardStartActivity::class.java).apply {}
                startActivity(intent);
            }
            MotionEvent.ACTION_UP -> {
                val intent = Intent(this, DashboardStartActivity::class.java).apply {}
                startActivity(intent);
            }
        }
        false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_page3)

        this.username = intent.getStringExtra("USERNAME").toString()
        this.gender = intent.getStringExtra("GENDER").toString()
        this.age = intent.getIntExtra("AGE", 0);
        this.feet = intent.getIntExtra("FEET", 0);
        this.inches = intent.getIntExtra("INCHES", 0);
        this.weight = intent.getIntExtra("WEIGHT", 0);
        this.fitness = intent.getStringExtra("FITNESS").toString()

        findViewById<Button>(R.id.nextStep3).setOnTouchListener(startTouchListener)
    }
}