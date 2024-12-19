package com.singlepointsol.retrofit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.singlepointsol.retrofit.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)

        val responseLiveData : LiveData<Response<Albums>> = liveData {
            val response = retrofitService.getAlbums()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()
            if (albumList != null){
                while (albumList.hasNext()){
                    val albumsItem = albumList.next()

                    val userId = "User Id: ${albumsItem.userId} \n "
                    binding.title.append(userId)

                    val albumId = "Album Id: ${albumsItem.id}  \n"
                    binding.title.append(albumId)

                    val albumTitle = "Album Title: ${albumsItem.title} \n"
                    binding.title.append(albumTitle)}
            }
        })
        }
    }