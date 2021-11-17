package com.example.insomniac.ui.startscreens

import android.os.Bundle
import android.annotation.SuppressLint
import android.widget.Button
import android.view.View
import android.view.MotionEvent
import android.content.Intent
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.insomniac.R

class SignupPage2Activity: AppCompatActivity() {
    var username: String = "";
    var gender: String = "";
    var age: Int = 0;

    var feet: Int = 0;
    var inches: Int = 0;
    var weight: Int = 0;
    var fitness: String = "";

    @SuppressLint("ClickableViewAccessibility")
    private val startTouchListener = View.OnTouchListener { view, motionEvent ->
        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                setupScreen()
                val intent = Intent(this, SignupPage3Activity::class.java).apply {}
                intent.putExtra("USERNAME", this.username)
                intent.putExtra("GENDER", this.gender)
                intent.putExtra("AGE", this.age)
                intent.putExtra("FEET", this.feet)
                intent.putExtra("INCHES", this.inches)
                intent.putExtra("WEIGHT", this.weight)
                intent.putExtra("FITNESS", this.fitness)
                Log.d("BOB Passed Username", this.username)
                startActivity(intent);
            }
            MotionEvent.ACTION_UP -> {
                setupScreen()
                val intent = Intent(this, SignupPage3Activity::class.java).apply {}
                intent.putExtra("USERNAME", this.username)
                intent.putExtra("GENDER", this.gender)
                intent.putExtra("AGE", this.age)
                intent.putExtra("FEET", this.feet)
                intent.putExtra("INCHES", this.inches)
                intent.putExtra("WEIGHT", this.weight)
                intent.putExtra("FITNESS", this.fitness)
                Log.d("BOB Passed Username", this.username)
                startActivity(intent);
            }
        }
        false
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_page2)

        this.username = intent.getStringExtra("USERNAME").toString()
        this.gender = intent.getStringExtra("GENDER").toString()
        this.age = intent.getIntExtra("AGE", 0);
        findViewById<Button>(R.id.nextStep2).setOnTouchListener(startTouchListener)
    }

    private fun setupScreen() {
        val tempFeet: EditText  = findViewById<EditText>(R.id.editFeet);
        var tempInches:  EditText = findViewById<EditText>(R.id.editInches);
        var tempWeight:  EditText = findViewById<EditText>(R.id.editWeight);
        var tempFitness:  EditText = findViewById<EditText>(R.id.editFitness);
        this.feet = tempFeet.text.toString().toInt();
        this.inches = tempInches.text.toString().toInt();
        this.weight = tempWeight.text.toString().toInt();
        this.fitness = tempFitness.text.toString();
    }
}