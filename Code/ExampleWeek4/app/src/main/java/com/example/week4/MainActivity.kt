package com.example.week4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.GridView
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {


    private var mobileArray = arrayOf("Android", "Iphone", "WindowMobile", "Blackberry", "WebOS");
    private var spinnerArray = arrayOf("Java", "Kotlin", "Python", "Swift");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val selection = findViewById<TextView>(R.id.selection);

        /*
         * List View Code
         */
/*        val listView = findViewById<ListView>(R.id.mobile_list);

        val adapter : ArrayAdapter<*> = ArrayAdapter(this, android.R.layout.simple_list_item_1, mobileArray);
        listView.adapter = adapter;*/


        /*
         * Spinner View Code
         */
/*        val spinner = findViewById<Spinner>(R.id.spinner);
        val spinnerAdapter : ArrayAdapter<*> = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArray);
        spinner.onItemSelectedListener = object :  AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
        spinner.adapter = spinnerAdapter;*/


        /*
         * Grid View Code
         */
/*        val gridView = findViewById<GridView>(R.id.gridview);
        val gridAdapter : ArrayAdapter<*> = ArrayAdapter(this, android.R.layout.simple_list_item_1, mobileArray);
        gridView.onItemClickListener = object :  AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                selection?.text = mobileArray[p2];
            }

        }

        gridView.adapter = gridAdapter;*/
        /*
         * Auto Complete View Code
         */
        var autoCompletion : AutoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.edit);
        val editAdapter : ArrayAdapter<*> = ArrayAdapter(this, android.R.layout.simple_list_item_1, mobileArray);
        autoCompletion.addTextChangedListener(object :  TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                selection.text = autoCompletion.text;
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        autoCompletion.setAdapter(editAdapter)
    }
}