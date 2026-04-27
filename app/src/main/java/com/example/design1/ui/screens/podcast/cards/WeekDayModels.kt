package com.example.design1.ui.screens.podcast.cards

internal data class WeekDayUi(
    val day: String,
    val date: String,
    val isCompleted: Boolean = false,
    val showIndicatorDots: Boolean = false,
    val isSelected: Boolean = false,
    val isDisabled: Boolean = false
)

