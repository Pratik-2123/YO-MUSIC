package com.example.yomusic.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yomusic.R


@Composable
fun LibraryScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row {
                Icon(painter = painterResource(id = R.drawable.playlist), contentDescription = null, modifier = Modifier.size(28.dp), tint = bg)
                Text(text = "PlayList", fontSize = 20.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(3.dp), color = bg)
            }
            Row {
                Icon(painterResource(id = R.drawable.arrow_right), contentDescription = null, tint = bg)
            }
        }

        Divider(modifier = Modifier.padding(10.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row {
                Icon(painter = painterResource(id = R.drawable.mic), contentDescription = null, modifier = Modifier.size(28.dp), tint = bg)
                Text(text = "Artists", fontSize = 20.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(3.dp), color = bg)
            }
            Row {
                Icon(painterResource(id = R.drawable.arrow_right), contentDescription = null, tint = bg)
            }
        }

        Divider(modifier = Modifier.padding(10.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row {
                Icon(painter = painterResource(id = R.drawable.album), contentDescription = null, modifier = Modifier.size(28.dp), tint = bg)
                Text(text = "Album", fontSize = 20.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(3.dp),color = bg)
            }
            Row {
                Icon(painterResource(id = R.drawable.arrow_right), contentDescription = null, tint = bg)
            }
        }

        Divider(modifier = Modifier.padding(10.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row {
                Icon(painter = painterResource(id = R.drawable.song), contentDescription = null, modifier = Modifier.size(28.dp), tint = bg)
                Text(text = "Songs", fontSize = 20.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(3.dp), color = bg)
            }
            Row {
                Icon(painterResource(id = R.drawable.arrow_right), contentDescription = null, tint = bg)
            }
        }

        Divider(modifier = Modifier.padding(horizontal = 3.dp, vertical = 10.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row {
                Icon(painter = painterResource(id = R.drawable.genre), contentDescription = null, modifier = Modifier.size(28.dp), tint = bg)
                Text(text = "Genre", fontSize = 20.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(3.dp), color = bg)
            }
            Row {
                Icon(painterResource(id = R.drawable.arrow_right), contentDescription = null, tint = bg)
            }
        }
    }
}