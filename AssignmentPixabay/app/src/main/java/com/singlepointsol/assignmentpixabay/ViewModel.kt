package com.singlepointsol.assignmentpixabay

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

open class ViewModel : ViewModel() {
    private val _images = MutableStateFlow<List<RetrofitService.ImageItem>>(emptyList())
    val images: StateFlow<List<RetrofitService.ImageItem>> get() = _images

    private val apiKey = "YOUR_API_KEY"

    fun fetchImages(query: String) {
        viewModelScope.launch {
            try {
                val response = ApiClient.pixabayService.getImages(apiKey, query)
                _images.value = response.hits
            } catch (_: Exception) {
            }
        }
    }
}