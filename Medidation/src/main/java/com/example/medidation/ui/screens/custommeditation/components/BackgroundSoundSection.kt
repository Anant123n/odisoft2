package com.example.medidation.ui.screens.custommeditation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.medidation.ui.bigSubtitleCenteredStyle
import com.example.medidation.ui.screens.custommeditation.CardBackground
import com.example.medidation.ui.screens.custommeditation.PrimaryText
import com.example.medidation.ui.screens.custommeditation.SelectedWhaleBackground
import com.example.medidation.ui.screens.custommeditation.SelectedWhaleBorder
import com.example.medidation.ui.screens.custommeditation.SoundCardStyle
import com.example.medidation.ui.screens.custommeditation.SoundOption
import com.example.medidation.ui.screens.homepage.components.HomepageAssetImage

@Composable
internal fun BackgroundSoundSection(
    soundOptions: List<SoundOption>,
    selectedSoundTitle: String,
    onSoundSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Choose a Background Sound",
            color = PrimaryText,
            style = bigSubtitleCenteredStyle(),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        soundOptions.chunked(2).forEach { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                rowItems.forEach { option ->
                    SoundCard(
                        option = option,
                        selected = option.title == selectedSoundTitle,
                        onClick = { onSoundSelected(option.title) },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
private fun SoundCard(
    option: SoundOption,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(16.dp)
    val backgroundColor = if (selected && option.style != SoundCardStyle.FullImage) {
        SelectedWhaleBackground
    } else {
        CardBackground
    }
    val borderColor = if (selected) SelectedWhaleBorder else Color.Transparent
    val borderWidth = if (selected) 2.dp else 0.dp

    Box(
        modifier = modifier
            .height(138.dp)
            .clip(shape)
            .background(backgroundColor)
            .border(borderWidth, borderColor, shape)
            .clickable(onClick = onClick)
    ) {
        when (option.style) {
            SoundCardStyle.Fill -> {
                option.assetPath?.let { asset ->
                    HomepageAssetImage(
                        assetPath = asset,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                option.overlayAssetPath?.let { overlay ->
                    HomepageAssetImage(
                        assetPath = overlay,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        alpha = 0.82f
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    CardBackground,
                                    CardBackground.copy(alpha = 0f)
                                ),
                                startY = 0f,
                                endY = 92f
                            )
                        )
                )
            }

            SoundCardStyle.FitBottom -> {
                option.assetPath?.let { asset ->
                    HomepageAssetImage(
                        assetPath = asset,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .width((option.imageWidth ?: 120).dp)
                            .height((option.imageHeight ?: 80).dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }

            SoundCardStyle.FullImage -> {
                option.assetPath?.let { asset ->
                    HomepageAssetImage(
                        assetPath = asset,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }

        if (option.style != SoundCardStyle.FullImage) {
            Text(
                text = option.title,
                color = PrimaryText,
                style = bigSubtitleCenteredStyle(),
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 16.dp)
            )
        }
    }
}
