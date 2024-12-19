package com.example.ticketbooking

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import com.singlepointsol.ticketbooking.R
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener, TimePickerDialog.OnTimeSetListener,
    DatePickerDialog.OnDateSetListener {

    lateinit var source: EditText
    lateinit var destination: EditText
    lateinit var datePickerButton: Button
    lateinit var timePickerButton: Button
    lateinit var submitButton: Button

    private var selectedDate = ""
    private var selectedTime = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        source = findViewById(R.id.source_et)
        destination = findViewById(R.id.destination_et)
        datePickerButton = findViewById(R.id.date_button)
        timePickerButton = findViewById(R.id.time_button)
        submitButton = findViewById(R.id.submit_button)

        datePickerButton.setOnClickListener(this)
        timePickerButton.setOnClickListener(this)
        submitButton.setOnClickListener(this)
    }
    override fun onClick(p0: View?)  {
        val calendar = Calendar.getInstance()
        val hour: Int = calendar.get(Calendar.HOUR_OF_DAY)
        val minute: Int = calendar.get(Calendar.MINUTE)
        val year :Int = calendar.get(Calendar.YEAR)
        val month :Int = calendar.get(Calendar.MONTH)
        val day :Int = calendar.get(Calendar.DAY_OF_MONTH)
        if (p0 != null)
            when(p0.id){
                R.id.time_button -> {
                    TimePickerDialog(this, this, hour, minute, true).show()
                }

                R.id.date_button -> {
                    DatePickerDialog(this, this, year, month, day).show()
                }
            }

    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int){
        val timeSelected = "$p1:$p2"
        timePickerButton.text = timeSelected
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int)  {
        val dateSelected = "${p2+1}/$p3/$p2"
        datePickerButton.text = dateSelected
    }



}