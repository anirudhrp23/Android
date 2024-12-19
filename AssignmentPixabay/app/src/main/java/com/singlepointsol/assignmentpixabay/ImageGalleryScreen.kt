package com.singlepointsol.assignmentpixabay

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ImageGalleryScreen(viewModel: ViewModel = viewModel) {
    val images by viewModel.images.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchImages("nature") // Example query
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Pixabay Image Gallery") }) }
    ) {
        LazyColumn(contentPadding = PaddingValues(8.dp)) {
            items(images) { image ->
                ImageCard(image)
            }
        }
    }
}

@Composable
fun ImageCard(image: Int) {
    Card(
        shape = RoundedCornerShape(8.dp), elevation = 4.dp,
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        Column {
            val painter: Painter = rememberImagePainter(image.webformatURL)
            Image(
                painter = painter, contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(200.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(8.dp)) {
                Text("User: ${image.user}", style = MaterialTheme.typography.h6)
                Text("Likes: ${image.likes}")
                Text("Views: ${image.views}")
            }
        }
    }
}

