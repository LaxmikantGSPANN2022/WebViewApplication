package com.example.webviewapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContentInfo
import android.view.OnReceiveContentListener
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    lateinit var button : Button
    lateinit var buttonCustom : Button
    lateinit var webView : WebView

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        buttonCustom = findViewById(R.id.buttonCustomWebView)
        webView = findViewById(R.id.webviewComponent)

        button.setOnClickListener(View.OnClickListener {
            loadUrl()
        })

        buttonCustom.setOnClickListener(View.OnClickListener {
            webView.webViewClient = CustomWebView()
            webView.loadUrl("https://www.google.co.in/")
//            Toast.makeText(this@MainActivity, webView.url, Toast.LENGTH_SHORT).show()
//            Toast.makeText(this@MainActivity, webView.getTitle(), Toast.LENGTH_SHORT).show()
        })
    }

    private fun loadUrl() {
        Toast.makeText(this@MainActivity, "Button Clicked!", Toast.LENGTH_SHORT).show()
        webView.loadUrl("https://www.wikipedia.org/")
    }

    class CustomWebView : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            view?.loadUrl("https://www.google.co.in/")
            return true
        }

        override fun onReceivedError(
            view: WebView?,
            request: WebResourceRequest?,
            error: WebResourceError?
        ) {
            super.onReceivedError(view, request, error)
        }
    }
}