package com.example.design1.ui.screens.podcast.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.design1.R
import com.example.design1.ui.bigSubtitleLeftStyle
import com.example.design1.ui.bodySmallCenteredStyle
import com.example.design1.ui.bodySmallLeftStyle
import com.example.design1.ui.h4Style

@Composable
internal fun ArcDeepDiveSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    0f to Color.White.copy(alpha = 0.1f),
                    1f to Color(0xFF371E18).copy(alpha = 0.1f)
                ),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.padding(bottom = 43.dp), contentAlignment = Alignment.BottomCenter) {
            Box(
                modifier = Modifier
                    .size(width = 361.dp, height = 203.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        brush = Brush.verticalGradient(listOf(Color(0xFF574C47), Color(0xFF292423))),
                        alpha = 0.5f
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar_right_49fcaf),
                    contentDescription = null,
                    modifier = Modifier
                        .size(106.dp)
                        .align(Alignment.BottomStart)
                        .offset(x = (-17).dp, y = 4.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = painterResource(id = R.drawable.avatar_left_463f98),
                    contentDescription = null,
                    modifier = Modifier
                        .size(118.dp)
                        .align(Alignment.BottomEnd)
                        .offset(x = 32.dp, y = 10.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        "Arc Deep Dive",
                        color = Color(0xFFF2EBE9),
                        style = h4Style().copy(fontSize = 24.sp, textAlign = TextAlign.Center),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        "Listen to the podcast about the full analysis\nof your personality\n3 Hours",
                        color = Color(0xFFF2EBE9),
                        style = bodySmallCenteredStyle(),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(330.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 32.dp)
                        .size(width = 166.dp, height = 54.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .background(Color(0xFFF2EBE9).copy(alpha = 0.4f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Start Listening", color = Color(0xFF171312), style = bigSubtitleLeftStyle().copy(textAlign = TextAlign.Center))
                }
            }

            Box(
                modifier = Modifier
                    .offset(y = 43.dp)
                    .size(width = 347.dp, height = 86.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF423C3A))
                    .border(0.5.dp, Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("The Podcast is Locked", color = Color(0xFFF2EBE9), style = bigSubtitleLeftStyle())
                        Text("Unlock it by taking personality test", color = Color(0xFFF2EBE9), style = bodySmallLeftStyle())
                    }
                    Image(painter = painterResource(id = R.drawable.lock_arrow_button), contentDescription = null, modifier = Modifier.size(36.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(43.dp))
    }
}

