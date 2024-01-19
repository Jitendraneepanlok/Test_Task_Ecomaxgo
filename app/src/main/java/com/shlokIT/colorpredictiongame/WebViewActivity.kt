package com.shlokIT.colorpredictiongame

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

class WebViewActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppFullScreenTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        /*webView = findViewById(R.id.webView)
        webView.clearCache(true)
        webView.clearHistory()
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://dhan-laxmi.in/")
        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.settings.setSupportZoom(true)
    }
    override fun onBackPressed() {
        if (webView.canGoBack())
            webView.goBack()
        else
            super.onBackPressed()
    }*/
    }
}