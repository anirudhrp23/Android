package com.singlepointsol.roomdatabase

import android.media.RouteListingPreference
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ViewModel(private val dao: Dao) : ViewModel() {

    private val _items = MutableStateFlow<List<Details>>(emptyList())
    val items: MutableStateFlow<List<Details>> = _items

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            _items.value = dao.getAll()
        }
    }

    fun insertItem(item: RouteListingPreference.Item) {
        viewModelScope.launch {
            dao.insertItem(item)
            fetchItems()
        }
    }

    fun deleteItem(item: RouteListingPreference.Item) {
        viewModelScope.launch {
            dao.deleteItem(item)
            fetchItems()
        }
    }
}
