package com.example.javascript

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.javascript.ui.theme.JavaScriptTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JavaScriptTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = paddingValues.calculateTopPadding(),
                                bottom = paddingValues.calculateBottomPadding()
                            ),
                        verticalArrangement = Arrangement.Center,

                        ) {
                        SimpleWebView()
                    }

                }
            }
        }
    }
}


