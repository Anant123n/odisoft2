package com.example.design1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.design1.ui.PodcastScreen
import com.example.design1.ui.theme.Design1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Design1Theme(darkTheme = true, dynamicColor = false) {
                PodcastScreen()
            }
        }
    }
}
