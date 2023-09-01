package com.example.urlinteraction

import android.app.Activity
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import java.lang.Exception
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import kotlin.concurrent.thread

class MainActivity : Activity() {
//    private lateinit var textContent:TextView
    private lateinit var imageContent:ImageView
    private lateinit var requestButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        textContent = findViewById(R.id.textContent)
        imageContent = findViewById(R.id.imageContent)
        requestButton = findViewById(R.id.requestButton)
        requestButton.setOnClickListener { requestImage("https://content1.rozetka.com.ua/goods/images/big/273405876.jpg") }
//        requestButton.setOnClickListener { request("https://example.com") }
    }

    fun requestImage(webAdress:String) {
        thread {
            val handler = Handler(Looper.getMainLooper())
            var urlConnection:HttpsURLConnection? = null

            try {
                val url = URL(webAdress)
                urlConnection = url.openConnection() as HttpsURLConnection
                val code = urlConnection.responseCode

                if (code == 200) {
                    val inputStream = urlConnection.inputStream
                    val bitMap = BitmapFactory.decodeStream(inputStream)

                    handler.post { imageContent.setImageBitmap(bitMap) }
                }

            } catch (e:java.lang.Exception) {

            } finally {
                urlConnection?.disconnect()
            }
        }
    }

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
