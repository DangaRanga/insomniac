package com.example.insomniac

import android.content.Intent

import android.os.Bundle
import android.os.Handler
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import com.example.insomniac.model.UserViewModel
import com.example.insomniac.model.user.User
import com.example.insomniac.ui.dashboard.DashboardStartActivity


class SplashScreenActivity : AppCompatActivity() {
    lateinit var user: List<User>
    lateinit var userviewmodel: UserViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splahscreen)
        Handler().postDelayed(Runnable { //This method will be executed once the timer is over
            userviewmodel = UserViewModel(application)
            user = userviewmodel.getAllUsers()
            Log.v("user item", user.size.toString())
            if(user.isEmpty()){
                startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this@SplashScreenActivity, DashboardStartActivity::class.java))
                finish()
            }
        }, 2000)

    }
}