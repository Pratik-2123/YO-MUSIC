package com.example.yomusic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties

@Composable
fun Add_Account(dialogOpen : MutableState<Boolean>) {
    if(dialogOpen.value) {
        AlertDialog(
            onDismissRequest = {dialogOpen.value = false},
            confirmButton = {
                TextButton(onClick = { dialogOpen.value = false }) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { dialogOpen.value = false }) {
                    Text(text = "Dismiss")
                }
            },
            text = {
                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Add Account", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    TextField(value = "", onValueChange = {}, label = { Text(text = "Email")}, modifier = Modifier.padding(top = 16.dp))
                    TextField(value = "", onValueChange = {}, label = { Text(text = "Password")}, modifier = Modifier.padding(top = 8.dp))
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.Transparent),
            shape = RoundedCornerShape(16.dp),
            backgroundColor = Color.White,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        )
    }
}