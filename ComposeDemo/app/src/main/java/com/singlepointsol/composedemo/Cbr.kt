package com.singlepointsol.composedemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Cbr() {
    Row {
        Image(painterResource(R.drawable.cbr), "",
            modifier = Modifier.size(150.dp))
        Column {
            Text(text = "Honda")
            Text(text = "Fireblade CBR 1000RRR")

        }
    }
}