package com.example.week10

import android.content.ContentResolver
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Contacts
import android.provider.MediaStore
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    var listView : ListView? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView);
        var selection = arrayOf<String>(MediaStore.Images.Media._ID, MediaStore.Images.Media.DISPLAY_NAME);
        var cursor = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection, null, null)
        } else {
            TODO("VERSION.SDK_INT < O")
        };
        val list = ArrayList<String>();
        while(cursor?.moveToNext() == true) {
            var string = "";
                cursor?.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)?.let {
                    string =  cursor.getString(it)
                    if (string != null) {
                        list.add(string)
                    }
                };

        }
        Toast.makeText(this, list.size.toString(), Toast.LENGTH_SHORT).show();
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView?.adapter = adapter;
    }
}