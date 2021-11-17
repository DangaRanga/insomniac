package com.example.insomniac.ui.startscreens

import android.os.Bundle
import android.annotation.SuppressLint
import android.content.Context
import android.widget.Button
import android.view.View
import android.view.MotionEvent
import android.content.Intent
import android.graphics.Typeface
import android.util.Log
import android.util.TypedValue
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.app.AppCompatActivity
import com.example.insomniac.R
import android.widget.ArrayAdapter
import android.widget.AdapterView

import android.widget.AdapterView.OnItemSelectedListener
import android.widget.TextView

import androidx.core.content.res.ResourcesCompat













class SignupPage1Activity: AppCompatActivity() {
    var username = "";
    var gender = "";
    var age = 0;

//    val typeface = ResourcesCompat.getFont(Context context, R.font.poppins_medium)

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

        val genderItems = arrayOf("Male", "Female")
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, genderItems
        )
        var tempGender:  Spinner = findViewById<Spinner>(R.id.editGender);
        tempGender.setAdapter(adapter)

        tempGender.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>, view: View,
                position: Int, id: Long
            ) {
                (view as TextView).setTextColor(resources.getColor(R.color.white))
                (view as TextView).setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
//                (view as TextView).setTypeface(
//                    Typeface.createFromAsset(getAssets(),
//                    "fonts/poppins_medium.ttf"))
                Log.v("gender item", (parent.getItemAtPosition(position) as String)!!)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // TODO Auto-generated method stub
            }
        })
        findViewById<Button>(R.id.nextStep1).setOnTouchListener(startTouchListener)
    }

    private fun setupScreen() {
        val tempUsername: EditText  = findViewById<EditText>(R.id.editPersonName);
        var tempGender:  Spinner = findViewById<Spinner>(R.id.editGender);
        var tempAge:  EditText = findViewById<EditText>(R.id.editAge);
        this.username = tempUsername.text.toString();
        this.gender = tempGender.getSelectedItem().toString();
        if(tempAge.text.toString().toInt() == null){
            this.age = 0
        }else{
            this.age = tempAge.text.toString().toInt();
        }

//        print(tempAge)

    }
}