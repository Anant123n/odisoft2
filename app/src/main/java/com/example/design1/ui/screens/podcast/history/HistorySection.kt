package com.example.design1.ui.screens.podcast.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.design1.R
import com.example.design1.ui.bodySmallCenteredStyle
import com.example.design1.ui.h4CenteredStyle
import com.example.design1.ui.screens.podcast.history.HistoryCard

@Composable
internal fun HistorySection(onCardClick: (Int) -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Pod History", color = Color(0xFFF2EBE9), style = h4CenteredStyle())
            Text("Explore your podcast history from recent weeks", color = Color(0xFFF2EBE9), style = bodySmallCenteredStyle())
        }
        Spacer(modifier = Modifier.height(16.dp))
        HistoryCard("January 20-26", "Exploring your personal values and beliefs", "3h:00m", R.drawable.history_card_1_bg, R.drawable.right_button_1, R.drawable.play_button_1, 0.64f, onClick = { onCardClick(0) })
        Spacer(modifier = Modifier.height(8.dp))
        HistoryCard("January 13-19", "The impact of your environment on behavior", "1h:45m", R.drawable.history_card_2_bg, R.drawable.right_button_2, R.drawable.play_button_2, 0.50f, onClick = { onCardClick(1) })
        Spacer(modifier = Modifier.height(8.dp))
        HistoryCard("January 5-12", "What makes you the way you are", "2h:30m", R.drawable.history_card_3_bg, R.drawable.right_button_3, R.drawable.play_button_3, 0.78f, onClick = { onCardClick(2) })
    }
}
