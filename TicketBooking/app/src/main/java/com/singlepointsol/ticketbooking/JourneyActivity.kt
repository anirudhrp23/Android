package com.example.ticketbooking

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.singlepointsol.ticketbooking.R

class JourneyDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey_details)

        val source = intent.getStringExtra("source")
        val destination = intent.getStringExtra("destination")
        val date = intent.getStringExtra("date")
        val time = intent.getStringExtra("time")


    }
}