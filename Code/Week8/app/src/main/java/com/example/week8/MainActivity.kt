package com.example.week8

import android.app.Activity
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MainActivity : AppCompatActivity() {
    var buttonSendMessage : Button? = null;
    var editText : EditText? = null;
    var feedBack : TextView? = null;
    var sendBroadCastBtn : Button? = null;
    override fun onCreate(savedInstanceState: Bundle?) {

        var receiver = MyBroadCastReceiver();
        var intentFiler = IntentFilter("com.example.ACTION_MY_EVENT");
        registerReceiver(receiver, intentFiler);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonSendMessage = findViewById(R.id.send_message);
        editText = findViewById(R.id.edit_text);
        sendBroadCastBtn = findViewById<Button?>(R.id.sendBroadCast);
        buttonSendMessage?.setOnClickListener {
            sendMessage();
        }

        sendBroadCastBtn?.setOnClickListener {
            var intent = Intent("com.example.ACTION_MY_EVENT");
            intent.putExtra("message" ,"this is a broadcast event");
            sendBroadcast(intent);

            var intent2 = Intent(this, GreetingActivity::class.java);
            startActivity(intent2);
        }
    }

    private fun sendMessage() {
        var fullName : String = editText?.text.toString();
        var message = "Hello, Bruh Bruh Lmao";
        var intent = Intent(this, GreetingActivity::class.java);
        intent.putExtra("fullName", fullName);
        intent.putExtra("message", message);
        intent.putExtra("feedback", message + fullName);
//        startActivity(intent);
        val MY_REQUEST_CODE = 1234;
        startActivityForResult(intent, MY_REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        feedBack = findViewById(R.id.feed_back);

        if(resultCode == Activity.RESULT_OK && requestCode == 1234) {
            var feedback = data?.getStringExtra("feedback");
            feedBack?.text = feedback;
        } else {
            feedBack?.text = "?!"
        }
    }
}