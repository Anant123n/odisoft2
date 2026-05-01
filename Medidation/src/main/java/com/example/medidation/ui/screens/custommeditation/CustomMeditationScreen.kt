package com.example.medidation.ui.screens.custommeditation

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.medidation.ui.screens.custommeditation.components.BackgroundSoundSection
import com.example.medidation.ui.screens.custommeditation.components.BeginMeditationButton
import com.example.medidation.ui.screens.custommeditation.components.CustomMeditationHeader
import com.example.medidation.ui.screens.custommeditation.components.DurationSection
import com.example.medidation.ui.screens.custommeditation.components.GuidedVoiceSection
import com.example.medidation.ui.screens.custommeditation.components.MentionSection
import com.example.medidation.ui.screens.homepage.components.MeditationDivider
import java.time.LocalTime

@Composable
internal fun CustomMeditationScreen(
    meditationTitle: String = "Morning Meditation",
    onClose: () -> Unit = {}
) {
    val initialTitle = remember(meditationTitle) {
        val timeBasedTitle = customMeditationTitles[defaultMeditationTitleIndex(LocalTime.now())]
        when {
            meditationTitle.isBlank() -> timeBasedTitle
            meditationTitle == "Morning Meditation" -> timeBasedTitle
            else -> meditationTitle
        }
    }
    var meditationTitleText by rememberSaveable { mutableStateOf(initialTitle) }
    var editingMeditationTitle by rememberSaveable { mutableStateOf(initialTitle) }
    var isEditingTitle by rememberSaveable { mutableStateOf(false) }
    var selectedDurationMinutes by rememberSaveable { mutableIntStateOf(customMeditationDurationOptions.first().minutes) }
    var selectedSoundTitle by rememberSaveable { mutableStateOf(customMeditationSoundOptions[3].title) }
    var selectedVoiceName by rememberSaveable { mutableStateOf(customMeditationVoiceOptions.first().name) }
    var hasMeditatedBefore by rememberSaveable { mutableStateOf<Boolean?>(null) }
    var mentionText by rememberSaveable { mutableStateOf("") }

    val view = LocalView.current
    DisposableEffect(Unit) {
        val window = (view.context as Activity).window
        val controller = WindowCompat.getInsetsController(window, view)

        controller.hide(WindowInsetsCompat.Type.systemBars())
        controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        onDispose {
            controller.show(WindowInsetsCompat.Type.systemBars())
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .verticalScroll(rememberScrollState())
        ) {
            CustomMeditationHeader(
                meditationTitle = meditationTitleText,
                isEditingTitle = isEditingTitle,
                editingMeditationTitle = editingMeditationTitle,
                onEditingMeditationTitleChange = { editingMeditationTitle = it },
                onEditTitle = {
                    editingMeditationTitle = meditationTitleText
                    isEditingTitle = true
                },
                onSaveTitle = {
                    val updatedTitle = editingMeditationTitle.trim()
                    if (updatedTitle.isNotEmpty()) {
                        meditationTitleText = updatedTitle
                    }
                    isEditingTitle = false
                },
                onClose = onClose
            )
            MeditationDivider()
            DurationSection(
                durationOptions = customMeditationDurationOptions,
                selectedDurationMinutes = selectedDurationMinutes,
                onDurationMinutesChange = { selectedDurationMinutes = it },
                hasMeditatedBefore = hasMeditatedBefore,
                onMeditatedBeforeChange = { hasMeditatedBefore = it }
            )
            GuidedVoiceSection(
                voiceOptions = customMeditationVoiceOptions,
                selectedVoiceName = selectedVoiceName,
                onVoiceSelected = { selectedVoiceName = it }
            )
            MeditationDivider()
            BackgroundSoundSection(
                soundOptions = customMeditationSoundOptions,
                selectedSoundTitle = selectedSoundTitle,
                onSoundSelected = { selectedSoundTitle = it }
            )
            MeditationDivider()
            MentionSection(
                mentionText = mentionText,
                onMentionTextChange = { mentionText = it }
            )
            MeditationDivider()
            BeginMeditationButton()
        }
    }
}

private fun defaultMeditationTitleIndex(now: LocalTime): Int {
    val hour = now.hour
    return when (hour) {
        in 5..11 -> 0
        in 12..16 -> 1
        in 17..20 -> 2
        else -> 3
    }
}
