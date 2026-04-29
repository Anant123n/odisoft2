package com.example.design1.ui.screens.podcast.settings.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.design1.R
import com.example.design1.ui.bigSubtitleCenteredStyle
import androidx.compose.material3.Text

@Composable
internal fun VoiceSettingsHeader(
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            "Podcast Settings",
            color = Color(0xFFF2EBE9),
            style = bigSubtitleCenteredStyle(),
            modifier = Modifier.align(Alignment.Center)
        )
        Image(
            painter = painterResource(id = R.drawable.podcast_settings_back_button),
            contentDescription = "Back",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .size(36.dp)
                .clickable(onClick = onBack)
        )
    }
}
