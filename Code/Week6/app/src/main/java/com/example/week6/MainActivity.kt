package com.example.week6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat

class MainActivity : AppCompatActivity() {
    var btn1 : Button? = null;
    var btn2  : Button? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn);
        btn1 = findViewById<Button>(R.id.btn1);
        btn2 = findViewById<Button>(R.id.btn2);

        btn1?.setOnClickListener {
            val popup : PopupMenu =  PopupMenu(this, this.btn2)
            popup.inflate(R.menu.option_menu)

            val menu = popup.menu;
            popup.setOnMenuItemClickListener {
                Toast.makeText(this@MainActivity, it.toString(), Toast.LENGTH_SHORT).show();
                true
            }
            popup.show();
        }
        registerForContextMenu(btn);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu);

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.setHeaderTitle("Context Menu");

        menuInflater.inflate(R.menu.contexmenu, menu);
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item)
    }
}