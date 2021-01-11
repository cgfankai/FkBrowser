package com.example.mybrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.main_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.setAppCacheEnabled(true)
        webView.settings.allowFileAccess = true
        webView.webViewClient = WebViewClient()
        toUrlBtn.setOnClickListener {
            val url = urlText.text.toString()
            webView.loadUrl(
                if (url.startsWith("http")) {
                    url
                } else {
                    "https://$url"
                }
            )
        }
    }
}
