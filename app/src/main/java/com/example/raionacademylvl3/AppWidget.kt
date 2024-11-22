package com.example.raionacademylvl3

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable

fun AppWidget(
    appEntity: AppEntity = AppObject.sepatu,
    onClick: (appEntity: AppEntity) -> Unit
) {
    Box(
        modifier = Modifier
            .width(170.dp)
            .height(250.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .shadow(0.4.dp, RoundedCornerShape (0.5.dp))
            .clickable { onClick(appEntity) }
    ) {
        Card(
            shape = RoundedCornerShape(
                topStart = 16.dp,
                topEnd = 16.dp,
                bottomStart = 0.dp,
                bottomEnd = 0.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .padding(1.dp)
        ) {
            AsyncImage(
                model = appEntity.image,
                contentDescription = appEntity.name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Column(modifier = Modifier.padding(top = 175.dp, start = 8.dp)) {
            Text(appEntity.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(1.dp))
            Text(appEntity.rating, fontSize = 14.sp)
        }
    }
}