package com.singlepointsol.composedemo.ui.theme

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun Login(){
    var name by remember { mutableStateOf("")}
    var email by remember {    mutableStateOf("")}
    var password by remember {   mutableStateOf("")}
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(value = name, onValueChange = {name = it}, label = { Text(text = "Name") }, modifier = Modifier.padding(top = 16.dp))
        OutlinedTextField(value = email, onValueChange = {email = it}, label = { Text(text = "Email") })
        OutlinedTextField(value = password, onValueChange = {password = it}, label = { Text(text = "Password") })
        Row(horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {}, modifier = Modifier.padding(top = 16.dp)) {
                Text(text = "Sign In")
                }
            Button(onClick = {
                Log.e("Login Details", "Name: $name, Email: $email, Password: $password")
            }, modifier = Modifier.padding(top = 16.dp)) {
                Text(text = "Sign Up")
        }

        }
    }
}