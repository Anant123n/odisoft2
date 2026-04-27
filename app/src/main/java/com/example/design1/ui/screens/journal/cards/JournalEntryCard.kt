package com.example.design1.ui.screens.journal.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.design1.R
import com.example.design1.ui.bigSubtitleLeftStyle
import com.example.design1.ui.bodySmallLeftStyle

@Composable
internal fun JournalEntryCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF292423))
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text("Clouds began to gather,\nmirroring my thoughts.", color = Color(0xFFF2EBE9), style = bigSubtitleLeftStyle())
                Text("I wondered if the shift in weather wo...", color = Color(0xCCF2EBE9), style = bodySmallLeftStyle())
            }
            EntryGalleryIcon()
        }
    }
}

@Composable
private fun EntryGalleryIcon() {
    Box(modifier = Modifier.size(width = 82.79.dp, height = 63.79.dp)) {
        Image(
            painter = painterResource(id = R.drawable.journal_entry_gallery_right),
            contentDescription = null,
            modifier = Modifier
                .offset(x = 24.dp, y = 0.dp)
                .size(48.dp)
                .rotate(15f)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.journal_entry_gallery_left),
            contentDescription = null,
            modifier = Modifier
                .offset(y = 5.dp, x = 0.dp)
                .size(48.dp)
                .rotate(-15f)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
    }
}

