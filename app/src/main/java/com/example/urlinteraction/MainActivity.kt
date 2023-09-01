package com.example.urlinteraction

import android.app.Activity
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException
import java.lang.Exception
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import kotlin.concurrent.thread

class MainActivity : Activity() {
//    private lateinit var imageContent:ImageView
    private lateinit var textContent: TextView
    private lateinit var requestButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        imageContent = findViewById(R.id.imageContent)
        textContent = findViewById(R.id.textContent)
        requestButton = findViewById(R.id.requestButton)

//        requestButton.setOnClickListener { request("https://example.com") }
//        requestButton.setOnClickListener { requestImage("https://content1.rozetka.com.ua/goods/images/big/273405876.jpg") }
//        requestButton.setOnClickListener {
//            Glide.with(this)
//                .load("https://content1.rozetka.com.ua/goods/images/big/273405876.jpg")
//                .into(imageContent)
//        }
//        requestButton.setOnClickListener {
//            Picasso.get()
//                .load("https://content1.rozetka.com.ua/goods/images/big/273405876.jpg")
//                .into(imageContent)
//        }

        requestButton.setOnClickListener {
            val client = OkHttpClient()
            val request = okhttp3.Request.Builder().url("https://example.com").build()
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {

                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        val handler = Handler(Looper.getMainLooper())
                        handler.post {
                            textContent.text = response.body?.string()
                        }
                    }
                }

            })
        }

    }

//    fun requestImage(webAdress:String) {
//        thread {
//            val handler = Handler(Looper.getMainLooper())
//            var urlConnection:HttpsURLConnection? = null
//
//            try {
//                val url = URL(webAdress)
//                urlConnection = url.openConnection() as HttpsURLConnection
//                val code = urlConnection.responseCode
//
//                if (code == 200) {
//                    val inputStream = urlConnection.inputStream
//                    val bitMap = BitmapFactory.decodeStream(inputStream)
//
//                    handler.post { imageContent.setImageBitmap(bitMap) }
//                }
//
//            } catch (e:java.lang.Exception) {
//
//            } finally {
//                urlConnection?.disconnect()
//            }
//        }
//    }

//    fun request(webAdress:String) {
//        thread {
//            val handler = Handler(Looper.getMainLooper())
//            var urlConnection: HttpsURLConnection? = null
//
//            try {
//                val url = URL(webAdress)
//                urlConnection = url.openConnection() as HttpsURLConnection
//                val code = urlConnection.responseCode
//
//                if (code == 200) {
//                    val inputStreamReader = InputStreamReader(urlConnection.inputStream)
//                    val bufferedStreamReader = BufferedReader(inputStreamReader)
//                    var line = ""
//                    while (bufferedStreamReader.readLine() != null) {
//                        line += bufferedStreamReader.readLine()
//                    }
//
//                    handler.post {
//                        textContent.text = line
//                    }
//                }
//
//            } catch (e: Exception) {
//
//            } finally {
//                urlConnection?.disconnect()
//            }
//        }
//    }
}
