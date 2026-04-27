package com.example.design1.ui.screens.podcast.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.design1.R
import com.example.design1.ui.robotoTimeStyle
import com.example.design1.ui.bigSubtitleCenteredStyle

@Composable
internal fun HeaderSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .padding(horizontal = 24.dp, vertical = 12.dp)
        ) {
            Text("9:30", color = Color(0xFFE6E1DB), style = robotoTimeStyle(), modifier = Modifier.align(Alignment.CenterStart))
            Image(
                painter = painterResource(id = R.drawable.status_icons),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(width = 46.dp, height = 17.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.camera_cutout),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .size(24.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(painter = painterResource(id = R.drawable.back_button), contentDescription = null, modifier = Modifier.size(36.dp))
            Text("Podcast", color = Color(0xFFF2EBE9), style = bigSubtitleCenteredStyle())
            Image(painter = painterResource(id = R.drawable.menu_button), contentDescription = null, modifier = Modifier.size(36.dp))
        }
    }
}

