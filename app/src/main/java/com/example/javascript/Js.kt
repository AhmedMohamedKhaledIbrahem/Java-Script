package com.example.javascript

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun SimpleWebView() {
    val context = LocalContext.current

    AndroidView(
        factory = {
            WebView(context).apply {

                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()
                addJavascriptInterface(WebAppInterface(context), "Android")
                setLayerType(View.LAYER_TYPE_NONE, null)
                scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY
                isScrollbarFadingEnabled = true
                setBackgroundColor(android.graphics.Color.TRANSPARENT)
                loadUrl("file:///android_asset/simple.html")
            }
        },
    )
}

class WebAppInterface(private val context: Context) {
    @JavascriptInterface
    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}