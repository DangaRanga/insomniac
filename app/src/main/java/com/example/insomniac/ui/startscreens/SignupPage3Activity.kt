package com.example.insomniac.ui.startscreens

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.insomniac.R
import com.example.insomniac.ui.dashboard.DashboardStartActivity

import com.example.insomniac.model.UserViewModel
import com.example.insomniac.model.user.User




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

    lateinit var user:User
    lateinit var userviewmodel: UserViewModel;


    @SuppressLint("ClickableViewAccessibility")
    private val startTouchListener = View.OnTouchListener { view, motionEvent ->
        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                userviewmodel = UserViewModel(application)
                user = User(0, this.username, this.gender, this.age, this.feet, this.inches, this.weight,
                                        this.fitness, this.insomnia, this.sleepApnea, this.narcolepsy)
                userviewmodel.insert(user);
                val intent = Intent(this, DashboardStartActivity::class.java).apply {}
                startActivity(intent);
            }
            MotionEvent.ACTION_UP -> {
                userviewmodel = UserViewModel(application)
                user = User(1, this.username, this.gender, this.age, this.feet, this.inches, this.weight, this.fitness, this.insomnia, this.sleepApnea, this.narcolepsy)
                userviewmodel.insert(user);
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
        setupScreen()
        findViewById<Button>(R.id.nextStep3).setOnTouchListener(startTouchListener)
    }

    private fun setupScreen() {
        val tempInsomnia: RadioButton = findViewById<RadioButton>(R.id.insomniaButton);
        var tempSleepApnea: RadioButton = findViewById<RadioButton>(R.id.sleepApneaButton);
        var tempNarcolepsy: RadioButton = findViewById<RadioButton>(R.id.narcolepsyButton);

        var isToggledRadio1 = false
        var isToggledRadio2 = false
        var isToggledRadio3 = false

        tempInsomnia.setOnClickListener(View.OnClickListener { v ->
            isToggledRadio1 = !isToggledRadio1 //Switch boolean value
            val checked = (v as RadioButton)
            if (checked.isChecked) {
                this.insomnia = true;
            } else {
                this.insomnia = false;
            }
            checked.isChecked = isToggledRadio1
        })
        tempSleepApnea.setOnClickListener(View.OnClickListener { v ->
            isToggledRadio2 = !isToggledRadio2 //Switch boolean value
            val checked = (v as RadioButton)
            if (checked.isChecked) {
                this.sleepApnea = true;
            } else {
                this.sleepApnea = false;
            }
            checked.isChecked = isToggledRadio2
        })
        tempNarcolepsy.setOnClickListener(View.OnClickListener { v ->
            isToggledRadio3 = !isToggledRadio3 //Switch boolean value
            val checked = (v as RadioButton)
            if (checked.isChecked) {
                this.narcolepsy = true;
            } else {
                this.narcolepsy = false;
            }
            checked.isChecked = isToggledRadio3
        })

    }
}