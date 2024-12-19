package com.singlepointsol.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.singlepointsol.composedemo.ui.theme.ComposeDemoTheme
import com.singlepointsol.composedemo.ui.theme.Login

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /*Column {
                Text(
                    text = "Hello",
                    color = Color.Cyan,
                    fontSize = 36.sp,
                    modifier = Modifier.padding(16.dp),
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "World",
                    color = Color.Black,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(8.dp),
                    fontWeight = FontWeight.W900
                )
                Row(horizontalArrangement = Arrangement.Center) { Button(onClick = { /*TODO*/ }) {
                    Text(text = "Click")
                }
                    ElevatedButton(onClick = { /*TODO*/ }) {
                        Text(text = "Open")
                    }
                    OutlinedButton(onClick = { /*TODO*/ }) {
                        Text(text = "Close")
                    }
                    FilledTonalButton(onClick = { /*TODO*/ }) {
                        Text(text = "Save")
                    }
                    FilledIconButton(onClick = { /*TODO*/ }) {
                        Text(text = "Load")
                    }
                    }
                Image(painter = painterResource(id = R.drawable.cbr), contentDescription = "CBR",
                    modifier = Modifier.padding(16.dp), alignment = Alignment.Center)

                Image(painter = painterResource(id = R.drawable.st765), contentDescription = "ST765",
                    modifier = Modifier.padding(16.dp), alignment = Alignment.Center)*/
            Example()
            }
        }
    }




