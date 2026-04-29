package com.example.design1.ui.screens.podcast.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.design1.R
import com.example.design1.ui.bigSubtitleCenteredStyle

@Composable
internal fun HeaderSection(
    onSettingsClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.back_button),
            contentDescription = null,
            modifier = Modifier.size(36.dp)
        )
        Text(
            "Podcast",
            color = Color(0xFFF2EBE9),
            style = bigSubtitleCenteredStyle()
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .clickable(onClick = onSettingsClick)
        ) {
            Image(
                painter = painterResource(id = R.drawable.menu_button),
                contentDescription = "Open podcast settings",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(36.dp)
            )
        }
    }
}
