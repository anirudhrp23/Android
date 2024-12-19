        package com.singlepointsol.jsondemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

        class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var employeesArray: ArrayList<Employee>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        employeesArray = ArrayList()
        val jsonData = loadJsonFromAssets("employee.json")
        val empArray = parseJson(jsonData)
        recyclerView.adapter = EmployeeAdapter(employeesArray)
      
        }
            private fun loadJsonFromAssets(filename: String): String {
                val inputStream = assets.open(filename)
                val bufferReader = BufferedReader(InputStreamReader(inputStream))
                return bufferReader.use{ it.readText()}
    }

            private fun parseJson(jsonData: String): JSONArray {
                val jsonObject = JSONObject(jsonData)
                val employeesJSONArray = jsonObject.getJSONArray("employees")

                for (i in 0 until employeesJSONArray.length()) {
                    val employee = employeesJSONArray.getJSONObject(i)
                    val name = employee.getString("name")
                    val email = employee.getString("email")
                    val phone = employee.getString("phone")
                    val designation = employee.getString("designation")
                    employeesArray.add(Employee(name, email, phone, designation))
                }
                return employeesJSONArray


            }

           
        }