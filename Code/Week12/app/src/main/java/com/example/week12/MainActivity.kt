package com.example.week12

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorManager
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity() {
    var mSensorManager : SensorManager? = null;
    var connectivity : ConnectivityManager? = null;
    var wifiManager : WifiManager? = null;
    var cameraBtn : Button? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sensorBtn = findViewById<Button>(R.id.sensorBtn);
        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager;

        sensorBtn.setOnClickListener {
            if(mSensorManager?.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null) {
                Toast.makeText(this, "Have sensor", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Dont have sensor", Toast.LENGTH_SHORT).show();

            }
        }
        connectivity = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager;

        var activeNetwork = connectivity?.activeNetworkInfo;

        var connectivityBtn = findViewById<Button>(R.id.connectivityBtn);
        var connectivityTv = findViewById<TextView>(R.id.connectivityTv);
        connectivityBtn.setOnClickListener {
            connectivityTv.text = activeNetwork.toString();
        }

        wifiManager = getSystemService(Context.WIFI_SERVICE) as WifiManager;
        var wifiBtn = findViewById<Button>(R.id.wifiBtn);
        wifiBtn.setOnClickListener {
            connectivityTv.text = wifiManager?.connectionInfo.toString();

        }
        cameraBtn = findViewById(R.id.camera);
        cameraBtn?.setOnClickListener {
            var intent = Intent(this, CameraActivity::class.java);
            startActivity(intent);
        }

    }
}