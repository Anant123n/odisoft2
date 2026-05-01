package com.example.medidation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.medidation.ui.Homepage
import com.example.medidation.ui.theme.Design1Theme

class Meditation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Design1Theme(darkTheme = true, dynamicColor = false) {
                Homepage()
            }
        }
    }
}
