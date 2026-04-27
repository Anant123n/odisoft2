package com.example.design1.ui.screens.podcast.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.design1.R
import com.example.design1.ui.bodySmallCenteredStyle
import com.example.design1.ui.h3Style

@Composable
internal fun HeroSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.hero_image_735834),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(244.dp)
                .clip(RoundedCornerShape(bottomStart = 80.dp, bottomEnd = 80.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "Podcasts Shaped by You",
            color = Color(0xFFF2EBE9),
            textAlign = TextAlign.Center,
            style = h3Style().copy(textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Our host Milo (mind) and Soma (body) will be organizing podcasts for you to reflect and grow.",
            color = Color(0xFFF2EBE9),
            textAlign = TextAlign.Center,
            style = bodySmallCenteredStyle(),
            modifier = Modifier.width(310.dp)
        )
    }
}

