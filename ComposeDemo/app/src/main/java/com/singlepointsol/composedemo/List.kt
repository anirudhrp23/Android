package com.singlepointsol.composedemo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

@Composable
fun List() {
    val bikes = listOf<String>(
        "Triumph Street Triple 765", "Honda Fireblade CBR 1000RRR",
        "BMW S1000RR", "Ducati Panigale V4", "Continental GT 650",
        "Harley Davidson Sportster 883", "Kawasaki Ninja ZX10R",
        "Suzuki GSX-R1000", "Yamaha R1",
        "MV Agusta Brutale", "Norton 900",
        "Triumph Tiger 900", "BMW R 1250 GS",
        "Ducati DesertX","Apache 310RR","Triumph Speed Twin","Royal Enfield Bullet",
        "Harley Davidson Sportster 1200","Kawasaki Ninja H2R","Suzuki GSX-S1000R",""
    )
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = " List of Bikes", modifier = Modifier.padding(16.dp), style = TextStyle(
                color = Color.Black, fontStyle= FontStyle.Italic,
                fontSize = TextUnit(value = 20.0F, type = TextUnitType.Sp)
            )
        )
        LazyColumn {
            items(bikes) { name ->
                Text(name, modifier = Modifier.padding(15.dp),
                    fontSize = TextUnit(value = 16.0F, type = TextUnitType.Sp),
                    color = Color.Red)
                Divider()
            }
    }
}
    }
