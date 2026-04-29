package com.example.design1.ui.screens.podcast.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.unit.dp
import com.example.design1.ui.bigSubtitleLeftStyle
import com.example.design1.ui.bodySmallLeftStyle
import com.example.design1.ui.screens.podcast.settings.SettingsToggleItem

@Composable
internal fun PodcastAccessSection(
    items: List<SettingsToggleItem>,
    toggleStates: Map<String, Boolean>,
    onToggleChange: (String, Boolean) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            "Podcast Access",
            color = Color(0xFFF2EBE9),
            style = bigSubtitleLeftStyle()
        )
        items.forEach { item ->
            PodcastAccessRow(
                item = item,
                isEnabled = toggleStates[item.id] ?: item.defaultEnabled,
                onToggleChange = { enabled -> onToggleChange(item.id, enabled) }
            )
        }
    }
}

@Composable
private fun PodcastAccessRow(
    item: SettingsToggleItem,
    isEnabled: Boolean,
    onToggleChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                item.title,
                color = Color(0xFFF2EBE9),
                style = bigSubtitleLeftStyle()
            )
            Text(
                item.subtitle,
                color = Color(0xFFB6B0AF),
                style = bodySmallLeftStyle()
            )
        }

        Box(
            modifier = Modifier
                .padding(start = 12.dp)
                .size(width = 56.dp, height = 34.dp)
                .clip(CircleShape)
                .background(if (isEnabled) Color(0xFFFE6847) else Color(0x1AFFFFFF))
                .clickable { onToggleChange(!isEnabled) }
        ) {
            Box(
                modifier = Modifier
                    .align(if (isEnabled) Alignment.CenterEnd else Alignment.CenterStart)
                    .padding(horizontal = 4.dp)
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFDFBF9))
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color(0x1AFFFFFF))
    )
}
