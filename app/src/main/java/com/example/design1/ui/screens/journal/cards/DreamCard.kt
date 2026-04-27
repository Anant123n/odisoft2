package com.example.design1.ui.screens.journal.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.design1.R
import com.example.design1.ui.bodyMediumLeftStyle
import com.example.design1.ui.captionSmallLeftStyle
import com.example.design1.ui.bigSubtitleLeftStyle

@Composable
internal fun DreamCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF292423))
            .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0x1AFFFFFF))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text("In Progress", color = Color(0xFFF2EBE9), style = captionSmallLeftStyle())
            }
            Text("Lion Stalking Hoopoe at Home", color = Color(0xFFF2EBE9), style = bigSubtitleLeftStyle())
            Text("I saw a lion chasing my beopoe which was...", color = Color(0xCCB6B0AF), style = bodyMediumLeftStyle())
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.new_icon_moon_4),
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                    contentScale = ContentScale.Crop
                )
                Text("Full Moon", color = Color(0xCCB6B0AF), style = captionSmallLeftStyle())
            }
        }
    }
}

