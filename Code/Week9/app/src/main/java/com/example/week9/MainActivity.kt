package com.example.week9

import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.week9.FeedReaderContract.FeedEntry
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {
    var sharedPref : Button? = null;
    var writeFile : Button? = null;
    var readFile : Button? = null;
    var wriable : Button? = null;
    var readable : Button? = null;
    var sqlite : Button? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var settings : SharedPreferences = getSharedPreferences("PREF", 0);
        var editor = settings.edit();
        editor.putString("silientMode", "Alo alo" );
        editor.commit()
        sharedPref = findViewById(R.id.sharedPref)
        sharedPref?.setOnClickListener {
            var message = settings.getString("silientMode", null);
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
        writeFile = findViewById(R.id.writeFile);
        writeFile?.setOnClickListener {
            var fis : FileInputStream = baseContext.openFileInput("hello_file");
            var isr = InputStreamReader(fis);
            var bufferReader = BufferedReader(isr);
            var sb = StringBuilder() ;
            bufferReader.useLines {
                it.forEach {
                    sb.append(it);
                }
            }
            Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
            fis.close();
        }

        readFile = findViewById(R.id.readFile);
        readFile?.setOnClickListener {
            var fileName = "hello_file";
            var str = "Hello World";
            var fos = openFileOutput(fileName, 0);
            fos.write(str.toByteArray());

            fos.close();
        }

        readable = findViewById(R.id.readable);
        readable?.setOnClickListener {
            var state = Environment.getExternalStorageState();
            var isReadale = Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
            Toast.makeText(this, isReadale.toString(), Toast.LENGTH_SHORT).show();

        }
        wriable = findViewById(R.id.writeable);
        wriable?.setOnClickListener {
            var state = Environment.getExternalStorageState();
            var isWritable = Environment.MEDIA_MOUNTED.equals(state);

            Toast.makeText(this, isWritable.toString(), Toast.LENGTH_SHORT).show();

        }

        sqlite = findViewById(R.id.sqlite);

        sqlite?.setOnClickListener {
            var mDbHelper = FeedReaderDbHelper(this);
            val db: SQLiteDatabase = mDbHelper.getReadableDatabase()


            val projection =
                arrayOf(FeedEntry._ID, FeedEntry.COLUMN_NAME_TITLE, FeedEntry.COLUMN_NAME_SUBTITLE)

            val selection = FeedEntry.COLUMN_NAME_TITLE + " = ?"
            val selectionArgs = arrayOf("My Title")
            val sortOrder = FeedEntry.COLUMN_NAME_SUBTITLE + " DESC"

            val cursor = db.query(
                FeedEntry.TABLE_NAME,  // The table to query
                projection,  // The columns to return
                selection,  // The columns for the WHERE clause
                selectionArgs,  // The values for the WHERE clause
                null,  // don't group the rows
                null,  // don't filter by row groups
                sortOrder // The sort order
            )


        }


    }
}