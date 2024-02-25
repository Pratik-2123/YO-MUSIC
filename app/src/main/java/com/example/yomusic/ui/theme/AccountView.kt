package com.example.yomusic.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.yomusic.R

@Composable
fun AccountView() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Account", modifier = Modifier.padding(end = 8.dp), tint = Color.Black)
                Column {
                    Text(text = "Pratik Patel", color = Color.Black)
                    Text(text = "@YOMUSIC", color = Color.Black)
                }
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null, tint = Color.Black)
            }
        }
        Divider()
        Row (
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ){
            Icon(painter = painterResource(id = R.drawable.ic_subscribe), contentDescription = null, modifier = Modifier.padding(end = 8.dp), tint = Color.Black)
            Text(text = "My Music", color = Color.Black)
        }
    }
}