package com.example.insomniac.ui.tips

import android.os.Bundle
import android.annotation.SuppressLint
import android.widget.Button
import android.view.View
import android.view.MotionEvent
import android.content.Intent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.insomniac.R
import com.example.insomniac.ui.startscreens.SignupPage1Activity
import android.graphics.drawable.Drawable


import androidx.core.content.ContextCompat
import com.example.insomniac.model.tips.TipsDao


class TipsPageActivity : AppCompatActivity() {
        //    private lateinit var binding: ActivityMainBinding
        val _tips4 = arrayOf(
            arrayOf("", "", "", ""),
            arrayOf("", "", "", ""),
            arrayOf("", "", "", ""),
            arrayOf("", "", "", ""),
        );
//        var TextView id1;
//        var  id1 : TextView;
//        var TextView tip_title1, tip_title2, tip_title3, tip_title4;
//        var TextView read_more1, read_more2, read_more3 read_more4 ;
//        var TextView data_1, data_2, data_3, data_4;
//        var TextView data_1;
//        var TextView data_2;
//        var TextView data_3;
//        var TextView data_4
//        ;
//        var ImageView image_1, image_2,image_3, image_4;




        @SuppressLint("ClickableViewAccessibility")
        private val startTouchListener = View.OnTouchListener { view, motionEvent ->
            when (motionEvent.action) {
                MotionEvent.ACTION_DOWN -> {
                    val intent = Intent(this, SignupPage1Activity::class.java).apply {}
                    startActivity(intent);
                }
                MotionEvent.ACTION_UP -> {
                    val intent = Intent(this, SignupPage1Activity::class.java).apply {}
                    startActivity(intent);
                }
            }
            false
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(com.example.insomniac.R.layout.tips)
            findViewById<Button>(com.example.insomniac.R.id.getStartedBtn).setOnTouchListener(startTouchListener)



            var tip_title1 = findViewById<TextView>(com.example.insomniac.R.id.tips_card_article1_text)
            var tip_title2 = findViewById<TextView>(com.example.insomniac.R.id.tips_card_article2_text)
            var tip_title3 = findViewById<TextView>(com.example.insomniac.R.id.tips_card_article3_text)
            var tip_title4 = findViewById<TextView>(com.example.insomniac.R.id.tips_card_article4_text)

            var image1=findViewById<ImageView>(com.example.insomniac.R.id.tips_card_article1_image)
            var image2= findViewById<ImageView>(com.example.insomniac.R.id.tips_card_article2_image)
            var image3 =findViewById<ImageView>(com.example.insomniac.R.id.tips_card_article3_image)
            var image4  =findViewById<ImageView>(com.example.insomniac.R.id.tips_card_article4_image)

            tip_title1.text = "xos"
            tip_title2.text = "yodi"
            tip_title3.text = "zcnf"
            tip_title4.text = "0ahshejd"

            //val imageResource1 = resources.getIdentifier("", null, packageName)
            //val imageResource2 = resources.getIdentifier("uri", null, packageName)
            //val imageResource3 = resources.getIdentifier("uri", null, packageName)
            //val imageResource4 = resources.getIdentifier("uri", null, packageName)

            //image1.setImageDrawable(ContextCompat.getDrawable(this, imageResource1))
            //image2.setImageDrawable(ContextCompat.getDrawable(this, imageResource2))
            //image3.setImageDrawable(ContextCompat.getDrawable(this, imageResource3))
            //image4.setImageDrawable(ContextCompat.getDrawable(this, imageResource4))


        }

//        fun populate tips(){
//
//
//
//        }
}
