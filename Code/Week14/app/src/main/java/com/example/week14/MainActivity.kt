package com.example.week14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var myWebView = findViewById<WebView>(R.id.webview);
//        myWebView.loadUrl("https://www.youtube.com/");
//
//
//
//        myWebView.webViewClient = object : WebViewClient() {
//            override fun onLoadResource(view: WebView?, url: String?) {
//                super.onLoadResource(view, url)
//            }
//        }


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.weather.example.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherAPI = retrofit.create(WeatherAPI::class.java)
        val call   = weatherAPI.getWeatherData("Hanoi") as Call<WeatherData>
        call.enqueue(object : Callback<WeatherData> {
            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Toast.makeText(this@MainActivity, data.toString(), Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this@MainActivity, "error", Toast.LENGTH_SHORT).show();
                }
            }

            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                Toast.makeText(this@MainActivity, "error", Toast.LENGTH_SHORT).show();
            }
        })
    }
}


