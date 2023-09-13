package com.example.week5

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TabHost
import android.widget.TextView
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val fmtDateAndTime = DateFormat.getDateTimeInstance();
//        val textView = findViewById<TextView>(R.id.textView);
//        val btnDate = findViewById<Button>(R.id.btnDate);
//        val btnTime = findViewById<Button>(R.id.btnTime);
//        val calendar = Calendar.getInstance();
//
//        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
//            calendar.set(Calendar.YEAR, year);
//            calendar.set(Calendar.MONTH, monthOfYear);
//            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//
//            val myFormat  = "dd/MM/yyyy";
//
//            val sdf = SimpleDateFormat(myFormat, Locale.ENGLISH);
//            textView.text = sdf.format(calendar.time);
//
//        }
//
//        val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
//            calendar.set(Calendar.HOUR_OF_DAY, hour);
//            calendar.set(Calendar.MINUTE, minute);
//            val myFormat = "hh:mm";
//            val sdf = SimpleDateFormat(myFormat);
//            textView.text = sdf.format(calendar.time);
//
//        }
//        btnDate.setOnClickListener{
//            DatePickerDialog(this@MainActivity, dateSetListener
//                , calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
//                calendar.get(Calendar.DAY_OF_MONTH)
//            ).show()
//        }
//
//        btnTime.setOnClickListener {
//            TimePickerDialog(this@MainActivity, timeSetListener,
//                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE)
//                , true).show();
//        }

        val tabs = findViewById<TabHost>(R.id.tabhost);
        tabs.setup()
        val spec  = tabs.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("1 - clock");
        tabs.addTab(spec);

        val spec2 = tabs.newTabSpec("tag2");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("2 - Login");
        tabs.addTab(spec2);
        tabs.currentTab = 0;

    }
}