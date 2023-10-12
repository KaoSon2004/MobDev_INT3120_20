package com.example.week13

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices


class MainActivity : AppCompatActivity() {
    var mFusedLocationClient : FusedLocationProviderClient? = null;
    var location : TextView? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mediaPlayer : MediaPlayer = MediaPlayer.create(this, R.raw.pop);

        var playMediaPlayer = findViewById<Button>(R.id.play_media_player);
        playMediaPlayer.setOnClickListener {
            mediaPlayer.start();
        }
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        location = findViewById(R.id.location);
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 101);
        }
        mFusedLocationClient?.lastLocation?.addOnSuccessListener {
            if(it != null) {
                location?.text = it.latitude.toString() + " " + it.longitude.toString();
            } else {
                location?.text = "location is null"
            }
        }
        mFusedLocationClient?.lastLocation?.addOnFailureListener {
            location?.text = "Failure"
        }
    }
}