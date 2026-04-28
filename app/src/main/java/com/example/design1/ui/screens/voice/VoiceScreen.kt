package com.example.design1.ui.screens.voice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.design1.R
import com.example.design1.ui.screens.voice.components.AudioPlayerSection
import com.example.design1.ui.screens.voice.components.VoiceHeader
import com.example.design1.ui.screens.voice.components.VoiceMessage

@Composable
internal fun VoiceScreen(
    onBack: () -> Unit,
    visualRes: Int = R.drawable.blur_grey
) {
    val scrollState = rememberScrollState()
    var isTranscribing by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFF423C3A), Color(0xFF171312))
                )
            )
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            VoiceHeader(onBack = onBack)

            Box(modifier = Modifier.weight(1f)) {
                if (isTranscribing) {
                    // Chat Messages
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState)
                            .padding(horizontal = 16.dp, vertical = 32.dp),
                        verticalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        VoiceMessage(
                            sender = "Milo",
                            text = "Analysis complete! It looks like you might be dealing with some hidden anxieties. Have you had any anxiety recently? And do you remember the events that triggered them? Maybe try art therapy or dream journaling?",
                            avatarRes = R.drawable.avatar_left_463f98
                        )

                        VoiceMessage(
                            sender = "Soma",
                            text = "Analysis complete! It looks like you might be dealing with some hidden anxieties. Have you had any anxiety recently? And do you remember the events that triggered them? Maybe try art therapy or dream journaling?",
                            avatarRes = R.drawable.avatar_right_49fcaf,
                            highlightText = "Analysis complete! It looks like you might be dealing with some hidden anxieties."
                        )
                    }
                } else {
                    // Blurred Visual
                    Image(
                        painter = painterResource(id = visualRes),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            // Footer / Audio Player
            AudioPlayerSection(
                isTranscribing = isTranscribing,
                onToggleTranscription = { isTranscribing = !isTranscribing }
            )
        }
    }
}
