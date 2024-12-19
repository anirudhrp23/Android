package com.singlepointsol.composedemo

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun Example(){
    var expanded by remember { mutableStateOf(false) }
    Column (Modifier.clickable { expanded = !expanded }){
        Image(painterResource(R.drawable.st765),"",
            alignment = Alignment.Center)
        AnimatedVisibility(expanded) {
            Text( text = "Triumph Street Triple 765", style = MaterialTheme.typography.bodyLarge)

        }
        Image(painterResource(R.drawable.cbr),"",
            alignment = Alignment.Center)
        AnimatedVisibility(expanded) {
            Text( text = "Honda Fireblade CBR 1000RRR", style = MaterialTheme.typography.bodyLarge)
    }
}
}
