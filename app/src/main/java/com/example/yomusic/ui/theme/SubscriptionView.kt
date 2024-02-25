package com.example.yomusic.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SubscriptionView() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Manage Subscription", fontWeight = FontWeight.SemiBold, fontSize = 20.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(8.dp), color = bg)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = 50.dp,
            backgroundColor = Color.LightGray
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column {
                    Text(text = "Musical", color = bg, fontWeight = FontWeight.Medium)
                    Text(text = "Free Tier", color = bg, fontWeight = FontWeight.Medium)
                }
                Row {
                    Text(text = "See All Plans", color = lightPink, modifier = Modifier.padding(top = 3.dp))
                    Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null, tint = lightPink)
                }
            }
        }
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = 50.dp,
            backgroundColor = Color.LightGray
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ){
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = null, tint = bg)
                Text(text = "Get a Plan", fontWeight = FontWeight.Medium, modifier = Modifier.padding(top = 4.dp, start = 4.dp), color = bg)
            }
        }
    }
}