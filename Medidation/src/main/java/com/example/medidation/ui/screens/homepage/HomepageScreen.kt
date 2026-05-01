package com.example.medidation.ui.screens.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.medidation.ui.screens.homepage.components.BottomNavigationSection
import com.example.medidation.ui.screens.homepage.components.CategorySection
import com.example.medidation.ui.screens.homepage.components.HomeHeroSection
import com.example.medidation.ui.screens.homepage.components.MeditationInputBar

@Composable
internal fun HomepageScreen(
    onSendMeditation: (String) -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF171312))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(scrollState)
                    .padding(bottom = 24.dp),
                verticalArrangement = Arrangement.spacedBy(22.dp)
            ) {
                HomeHeroSection(
                    modifier = Modifier.fillMaxWidth(),
                    cards = promptCards
                )
                MeditationInputBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onSend = onSendMeditation
                )
                CategorySection(
                    modifier = Modifier.fillMaxWidth(),
                    items = categoryCards
                )
            }

            BottomNavigationSection(
                modifier = Modifier.fillMaxWidth(),
                items = bottomNavItems
            )
        }
    }
}
