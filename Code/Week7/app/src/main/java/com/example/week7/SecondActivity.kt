package com.example.week7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val btn2 = findViewById<Button>(R.id.btn2);
        val data = findViewById<TextView>(R.id.data);
        val dat = intent.getStringExtra("Ameo");
        data.text = dat;
        btn2.setOnClickListener {
            val intent : Intent = Intent(this, MainActivity::class.java);

            startActivity(intent);
        }

    }
}