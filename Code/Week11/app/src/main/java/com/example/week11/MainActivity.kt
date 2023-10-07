package com.example.week11

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            ActivityCompat.requestPermissions(
//                this, arrayOf(Manifest.permission.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION), 0
//            )
//        }

        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnStart);
        btn.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            intent.action = MyService.Actions.START.toString();
            startService(intent);
        }
    }
}