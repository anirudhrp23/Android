package com.singlepointsol.roomdatabase

import android.media.RouteListingPreference
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {
    @Query("Select * from items")
    fun getAll(): List<Details>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: RouteListingPreference.Item)

    @Delete
    suspend fun deleteItem(item: RouteListingPreference.Item)
}