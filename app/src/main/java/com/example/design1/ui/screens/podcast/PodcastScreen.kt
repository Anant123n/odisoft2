package com.example.design1.ui.screens.podcast

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.design1.R
import com.example.design1.ui.EmptyDayOverlay
import com.example.design1.ui.JournalDayOverlay
import com.example.design1.ui.screens.voice.VoiceScreen
import com.example.design1.ui.screens.podcast.cards.ArcDeepDiveSection
import com.example.design1.ui.screens.podcast.cards.MainCardSection
import com.example.design1.ui.screens.podcast.cards.WeekDayUi
import com.example.design1.ui.screens.podcast.header.HeaderSection
import com.example.design1.ui.screens.podcast.header.HeroSection
import com.example.design1.ui.screens.podcast.history.HistorySection

@Composable
internal fun PodcastScreen() {
    val mainScroll = rememberScrollState()
    val weekScroll = rememberScrollState()
    var activeSheet by remember { mutableStateOf<OverlaySheet?>(null) }
    var activeVoiceVisualRes by remember { mutableStateOf(R.drawable.blur_grey) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF171312))
                .verticalScroll(mainScroll)
        ) {
            HeaderSection()
            HeroSection()
            Spacer(modifier = Modifier.height(16.dp))
            MainCardSection(
                weekScroll = weekScroll,
                onDateClick = { day ->
                    activeSheet = if (day.isDisabled) OverlaySheet.Empty else OverlaySheet.Journal
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            ArcDeepDiveSection()
            Spacer(modifier = Modifier.height(20.dp))
            HistorySection(
                onCardClick = { cardIndex ->
                    activeVoiceVisualRes = if (cardIndex == 2) {
                        R.drawable.blur_orange
                    } else {
                        R.drawable.blur_grey
                    }
                    activeSheet = OverlaySheet.Voice
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Image(
                painter = painterResource(id = R.drawable.home_indicator),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(21.dp),
                contentScale = ContentScale.FillBounds
            )
        }

        when (activeSheet) {
            OverlaySheet.Journal -> JournalDayOverlay(onClose = { activeSheet = null })
            OverlaySheet.Empty -> EmptyDayOverlay(onClose = { activeSheet = null })
            OverlaySheet.Voice -> VoiceScreen(
                onBack = { activeSheet = null },
                visualRes = activeVoiceVisualRes
            )
            null -> Unit
        }
    }
}

private enum class OverlaySheet {
    Journal,
    Empty,
    Voice
}
