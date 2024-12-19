package com.singlepointsol.composefile

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.singlepointsol.composefile.ui.theme.ComposeFileTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeFileTheme{
                Scaffold {
                    ComposeFile()
                }
            }
        }
    }

@Composable
fun ComposeFile() {
    MaterialTheme{
        Surface (modifier = Modifier.fillMaxSize()){
            Input()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Input(){
    var text1 by remember {mutableStateOf("")}
    var text2 by remember {mutableStateOf("")}
    var text3 by remember {mutableStateOf("")}

    val database: DatabaseReference = FirebaseDatabase.getInstance().reference

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField (value = text1, onValueChange = { text1 = it },
            label = { Text("Name") },colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.LightGray),
            shape = RoundedCornerShape(8.dp), modifier = Modifier.fillMaxWidth().padding(16.dp)
                .align(Alignment.CenterHorizontally))

        OutlinedTextField(value = text2, onValueChange = { text2 = it },
            shape = RoundedCornerShape(8.dp), label = { Text("Email") },
            colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.LightGray),
            modifier = Modifier.fillMaxWidth().padding(16.dp).align(Alignment.CenterHorizontally))

        OutlinedTextField(value = text3, onValueChange = { text3 = it }, shape = RoundedCornerShape(8.dp),
            label = { Text("Phone") }, colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Color.LightGray),
            modifier = Modifier.fillMaxWidth().padding(16.dp).align(Alignment.CenterHorizontally))

        OutlinedButton (
            onClick = {
                val data = mapOf("Name" to text1, "Email" to text2, "Phone" to text3)
                database.child("inputs").push().setValue(data).addOnSuccessListener {
                    success -> if (true){
                        navigateToDisplayScreen(name = text1, email = text2, phone = text3)
                }

                    }  .addOnFailureListener { e ->
                         println("Failed to save data: ${e.message}") }
                      },modifier = Modifier.fillMaxWidth().padding(16.dp).align(Alignment.CenterHorizontally),
            shape = AbsoluteRoundedCornerShape(8.dp), border = BorderStroke(2.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green))

            {Text("Submit", color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)}
            }
    }
private fun navigateToDisplayScreen(name: String, email: String, phone: String){
    val intent = Intent(this, DisplayActivity::class.java).apply{
        putExtra("name", name)
        putExtra("email", email)
        putExtra("phone", phone)
    }
    startActivity(intent)
}
}







