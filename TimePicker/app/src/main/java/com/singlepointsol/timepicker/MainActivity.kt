package com.singlepointsol.timepicker

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener, TimePickerDialog.OnTimeSetListener,
    DatePickerDialog.OnDateSetListener {
    lateinit var timePicker:Button
    lateinit var datePicker:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        timePicker=findViewById(R.id.time_button)
        datePicker=findViewById(R.id.date_button)
        timePicker.setOnClickListener (this)
        datePicker.setOnClickListener (this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
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

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        val timeSelected = "$p1:$p2"
        timePicker.text = timeSelected
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        val dateSelected = "${p2+1}/$p3/$p2"
        datePicker.text = dateSelected
    }

    }

