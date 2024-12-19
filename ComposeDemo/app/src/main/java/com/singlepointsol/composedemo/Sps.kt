package com.singlepointsol.composedemo


import android.os.Message
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Sps() {
    Row(modifier = Modifier.padding(all = 36.dp).clip(CircleShape)) {
        Image(
            painter = painterResource(R.drawable.cbr),
            contentDescription = "",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(24.dp))

        Column {
            Text(text = "Honda")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Fireblade CBR 1000RRR")
        }
    }
}
