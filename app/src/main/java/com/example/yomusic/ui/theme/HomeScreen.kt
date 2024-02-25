package com.example.yomusic.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val categories = listOf("Hits","Happy","Running","TGIF","Yoga")
    val grouped = listOf("New Release","Favroites","Top Rated").groupBy { it[0] }
    
    LazyColumn{
        grouped.forEach{
            stickyHeader { 
                Text(text = it.value[0], modifier = Modifier.padding(start = 24.dp, top = 16.dp), color = bg, fontWeight = FontWeight.SemiBold, fontSize = 23.sp)
                LazyRow{
                    items(categories) {
                        cat->
                        BrowserItem(cat = cat)
                    }
                }
                Divider(modifier = Modifier.padding(horizontal = 18.dp))
            }
        }
    }
}

@Composable
fun BrowserItem(cat:String) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .size(130.dp)
            .clickable { }
            .clip(RoundedCornerShape(16.dp)),
        backgroundColor = lightPink
    )
        {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = cat)
        }
    }
}