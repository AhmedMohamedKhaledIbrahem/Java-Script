# Simple WebView with JavaScript Interface for Android
This simple project demonstrates how to use a WebView in an Android app to interact with JavaScript 
allowing communication between native Android code and web content.
# Feature
- JavaScript Interface: Allows communication between Android app and HTML/JavaScript.
- WebView in Jetpack Compose: Uses `AndroidView` to integrate `WebView` in a Jetpack Compose UI.
# How it work
1. The app loads a simple HTML page (`simple.html`) inside a `WebView`.
2. The HTML page contains a `sendMessage()` JavaScript function that interacts with Android code.
3. The Android app listens to JavaScript functions using `addJavascriptInterface`.
# Code Snippet
```kotlin
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

                // Load a secure HTTPS domain or local HTML file
                loadUrl("https://yourdomain.com/simple.html")
            }
        }
    )
}
```

```html
<!DOCTYPE html>
<html>
<head>
    <title>Simple Page</title>
    <script type="text/javascript">
	
        function sendMessage() {
            Android.showToast("Hello from JS!");
        }
        window.onload = function() {
            sendMessage();
        }
    </script>
</head>
<body style="background: transparent; margin: 0; padding: 0;">
</body>
</html>
```

