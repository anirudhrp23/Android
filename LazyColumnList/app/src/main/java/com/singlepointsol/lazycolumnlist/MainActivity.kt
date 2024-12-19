package com.singlepointsol.lazycolumnlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.singlepointsol.lazycolumnlist.ui.theme.LazyColumnListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           /* val bikesList = listOf<String>("Triumph Street Triple 765",
                "Honda Fireblade CBR 1000RRR", "BMW S1000RR",
                "Ducati Panigale V4", "Continental GT 650",
                "Harley Davidson Sportster 883", "Kawasaki Ninja ZX10R",
                "Suzuki GSX-R1000", "Yamaha R1", "MV Agusta Brutale",
                "Norton 900", "Triumph Tiger 900", "BMW R 1250 GS",
                "Ducati DesertX","Apache 310RR","Triumph Speed Twin","Royal Enfield Bullet",
                "Harley Davidson Sportster 1200","Kawasaki Ninja H2R","Suzuki GSX-S1000R")
            Bikes(bikesList)*/
            BikeList()
        }
    }
}


