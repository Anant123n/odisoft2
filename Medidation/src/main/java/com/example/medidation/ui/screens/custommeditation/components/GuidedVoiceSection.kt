package com.example.medidation.ui.screens.custommeditation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.medidation.ui.bigSubtitleCenteredStyle
import com.example.medidation.ui.screens.custommeditation.CardBackground
import com.example.medidation.ui.screens.custommeditation.PrimaryText
import com.example.medidation.ui.screens.custommeditation.SelectedWhaleBackground
import com.example.medidation.ui.screens.custommeditation.SelectedWhaleBorder
import com.example.medidation.ui.screens.custommeditation.VoiceOption
import com.example.medidation.ui.screens.homepage.components.HomepageAssetImage

@Composable
internal fun GuidedVoiceSection(
    voiceOptions: List<VoiceOption>,
    selectedVoiceName: String,
    onVoiceSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = "Select guided Voice",
            color = PrimaryText,
            style = bigSubtitleCenteredStyle()
        )

        voiceOptions.chunked(3).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            ) {
                rowItems.forEach { option ->
                    VoiceCard(
                        option = option,
                        selected = option.name == selectedVoiceName,
                        onClick = { onVoiceSelected(option.name) },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
private fun VoiceCard(
    option: VoiceOption,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(92.dp)
                .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                .border(
                    width = if (selected) 2.dp else 0.dp,
                    color = if (selected) SelectedWhaleBorder else Color.Transparent,
                    shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
                )
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFF423C3A), Color(0xFF171312))
                    )
                )
                .clickable(onClick = onClick)
        ) {
            HomepageAssetImage(
                assetPath = option.imageAsset,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-13).dp)
                .clip(RoundedCornerShape(8.dp))
                .background(if (selected) SelectedWhaleBackground else CardBackground)
                .padding(horizontal = 8.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = option.name,
                color = PrimaryText,
                style = bigSubtitleCenteredStyle(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
