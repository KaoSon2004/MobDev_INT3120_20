package com.example.week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.NumberPicker
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {
    var myAppBar : Toolbar? = null;
    var numberPicker : NumberPicker? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myAppBar = findViewById(R.id.appbar);
        setSupportActionBar(myAppBar);
        getSupportActionBar()?.setDisplayShowTitleEnabled(false);
        numberPicker  = findViewById(R.id.numberPicker);
        numberPicker?.setMinValue(998)
        numberPicker?.maxValue = 1000

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater : MenuInflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true
    }
}