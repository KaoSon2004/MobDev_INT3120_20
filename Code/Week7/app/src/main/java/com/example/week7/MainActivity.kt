package com.example.week7

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 = findViewById<Button>(R.id.btn1);
        val btn2 = findViewById<Button>(R.id.btn2);
        val btn3 = findViewById<Button>(R.id.btn3);
        val btn4 = findViewById<Button>(R.id.btn4);
        btn1.setOnClickListener {
            val intent : Intent = Intent(this, SecondActivity::class.java);
            intent.putExtra("Ameo", "Vinh Phuc 88 chuc mung nam moi anh em");
            startActivity(intent);
        }
        btn2.setOnClickListener {
            val intent = Intent();
            intent.action = Intent.ACTION_VIEW;
            intent.setData(Uri.parse("https://www.facebook"));
            startActivity(intent);
        }

        btn3.setOnClickListener {
            val intent = Intent();
            intent.action = Intent.ACTION_SENDTO;
            intent.putExtra("sms_body", "Bruh Lmaoe")
            intent.data = Uri.parse("sms:00000000000");
            startActivity(intent);
        }
        btn4.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND) // intent
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, "niranjantest@gmail.com")
            startActivity(intent)
        }
    }
}