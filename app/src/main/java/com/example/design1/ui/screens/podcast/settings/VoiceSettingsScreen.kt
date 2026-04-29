package com.example.design1.ui.screens.podcast.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.design1.R
import com.example.design1.ui.screens.podcast.settings.components.AnythingElseSection
import com.example.design1.ui.screens.podcast.settings.components.BackgroundMusicSection
import com.example.design1.ui.screens.podcast.settings.components.PodcastAccessSection
import com.example.design1.ui.screens.podcast.settings.components.PodcastStyleSection
import com.example.design1.ui.screens.podcast.settings.components.VoiceSettingsHeader

@Composable
internal fun VoiceSettingsScreen(
    onBack: () -> Unit
) {
    var notes by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    val toggleStates = remember {
        mutableStateMapOf<String, Boolean>().apply {
            podcastAccessItems.forEach { item -> put(item.id, item.defaultEnabled) }
            put(backgroundMusicItem.id, backgroundMusicItem.defaultEnabled)
        }
    }
    val sliderPositions = remember {
        mutableStateMapOf<String, Float>().apply {
            sliderSectionItems.forEach { item -> put(item.id, item.defaultPosition) }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF171312))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            VoiceSettingsHeader(onBack = onBack)

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(scrollState)
                    .padding(start = 16.dp, top = 32.dp, end = 16.dp, bottom = 48.dp),
                verticalArrangement = Arrangement.spacedBy(32.dp)
            ) {
                PodcastAccessSection(
                    items = podcastAccessItems,
                    toggleStates = toggleStates,
                    onToggleChange = { id, enabled -> toggleStates[id] = enabled }
                )
                PodcastStyleSection(
                    items = sliderSectionItems,
                    sliderPositions = sliderPositions,
                    onSliderChange = { id, position -> sliderPositions[id] = position }
                )
                BackgroundMusicSection(
                    item = backgroundMusicItem,
                    isEnabled = toggleStates[backgroundMusicItem.id] ?: backgroundMusicItem.defaultEnabled,
                    onToggleChange = { enabled -> toggleStates[backgroundMusicItem.id] = enabled }
                )
                AnythingElseSection(
                    value = notes,
                    onValueChange = { notes = it }
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.voice_settings_home_indicator),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(21.dp),
            contentScale = ContentScale.FillBounds
        )
    }
}
