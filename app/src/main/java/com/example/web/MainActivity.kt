package com.example.web

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.web.databinding.ActivityMainBinding


@SuppressLint("StaticFieldLeak")
lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        webViewSetUp()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun webViewSetUp(){
        val webview = binding.WebView1
        webview.webViewClient = WebViewClient()
        // we put webclient so that user don't go outside the external chrome ya web page
        webview.apply {
            loadUrl("https://www.google.com/search?q=cuims&rlz=1C1JZAP_enIN971IN971&oq=cuims&aqs=chrome.0.69i59j35i39j0i131i433i512l3j0i512l4.987j0j15&sourceid=chrome&ie=UTF-8")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true // safeBrowsingEnabled check is there malware or threads or not in webpage
        }

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {   // Press Backbutton to go previous page in Webview
        if (binding.WebView1.canGoBack()) binding.WebView1.goBack()
        else
        {
            super.onBackPressed()
        }
    }
}