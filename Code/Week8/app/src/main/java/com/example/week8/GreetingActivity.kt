package com.example.week8

import android.app.Activity
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class GreetingActivity : AppCompatActivity() {
    var content : TextView? = null;
    var backBtn : Button? = null;
    var fullName : String? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)
        fullName = intent.getStringExtra("fullName");
        backBtn = findViewById(R.id.back);

        backBtn?.setOnClickListener {
            var intent = Intent();
            var feedback : String = "OK, Hello" + fullName + "How are you";
            intent.putExtra("feedback", feedback);
            setResult(Activity.RESULT_OK, intent);
            finish()
        }


    }



}