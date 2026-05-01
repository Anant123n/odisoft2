package com.example.medidation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.medidation.ui.screens.custommeditation.CustomMeditationScreen
import com.example.medidation.ui.screens.homepage.HomepageScreen

private enum class MeditationRoute {
    Homepage,
    CustomMeditation
}

@Composable
internal fun Homepage() {
    var route by rememberSaveable { mutableStateOf(MeditationRoute.Homepage) }
    var customMeditationTitle by rememberSaveable { mutableStateOf("Morning Meditation") }

    when (route) {
        MeditationRoute.Homepage -> HomepageScreen(
            onSendMeditation = { typedText ->
                customMeditationTitle = typedText.ifBlank { "Morning Meditation" }
                route = MeditationRoute.CustomMeditation
            }
        )

        MeditationRoute.CustomMeditation -> CustomMeditationScreen(
            meditationTitle = customMeditationTitle,
            onClose = { route = MeditationRoute.Homepage }
        )
    }
}
