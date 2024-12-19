package com.singlepointsol.assignmentpictureapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.leanback.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.singlepointsol.assignmentpictureapi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var mountainArrayList: ArrayList<Moutain>
    private lateinit var mountainAdapter: MoutainAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        mountainArrayList = arrayListOf()
        mountainAdapter = MountainAdapter(mountainArrayList)
        recyclerView.adapter = mountainAdapter
        fetchFlowersData()
    }

    private fun fetchFlowersData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitInstance.getRetrofitInstance()
                    .create(Api::class.java)
                    .getMountain()

                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        val mountainList = response.body()?.hits ?: emptyList()
                        mountainArrayList.clear()
                        mountainArrayList.addAll(mountainList)
                        mountainAdapter.notifyDataSetChanged()
                    }
                }
            } catch (_: Exception) {
            }
        }
    }
}
