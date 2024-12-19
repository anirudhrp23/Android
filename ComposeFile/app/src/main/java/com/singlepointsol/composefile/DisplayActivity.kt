package com.singlepointsol.composefile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



class DisplayActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val firstInput = intent.getStringExtra("name") ?: ""
            val secondInput = intent.getStringExtra("email") ?: ""
            val thirdInput = intent.getStringExtra("phone") ?: ""

            DisplayScreen(firstInput, secondInput, thirdInput)
        }
    }
}

@Composable
fun DisplayScreen(firstInput: String, secondInput: String, thirdInput: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = " $firstInput", style = MaterialTheme.typography.bodyLarge)
        Text(text = " $secondInput", style = MaterialTheme.typography.bodyLarge)
        Text(text = " $thirdInput", style = MaterialTheme.typography.bodyLarge)
    }
}
