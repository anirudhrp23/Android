package com.singlepointsol.lazycolumnlist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Preview
@Composable
fun BikeList(modifier: Modifier = Modifier){
    LazyVerticalGrid()
}


@Composable
fun LazyVerticalGrid() {

    LazyVerticalGrid(columns = GridCells.Adaptive(150.dp), modifier = Modifier.fillMaxSize().padding(8.dp)) {
        itemsIndexed(items = getAllBikes()) { index, bike ->
            BikeItem(item = bike)
        }

    }
}

@Composable
fun BikeItem(item: Bike,modifier: Modifier = Modifier){
    var isExpanded by remember { mutableStateOf(false) }

    Card(modifier = Modifier.fillMaxWidth().padding(16.dp).background(color= Color.Transparent).clickable{isExpanded=!isExpanded},
        shape = RoundedCornerShape(40.dp),
        border = BorderStroke(4.dp, Color.Black)
    ) {

        Image(painter = painterResource(id = item.Image), contentDescription = "item.Make",
            modifier = Modifier.size(150.dp).align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.padding(6.dp))
        Column(Modifier.padding(8.dp).fillMaxSize().align(Alignment.CenterHorizontally),Arrangement.Center) {
            Text(text = item.Make, modifier = Modifier.align(Alignment.CenterHorizontally), style = TextStyle(color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.Bold))
            Text(text = item.Model,modifier = Modifier.align(Alignment.CenterHorizontally), style = TextStyle(color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Bold))

            Card(modifier = Modifier.size(112.dp).padding(8.dp).fillMaxWidth().align(Alignment.CenterHorizontally), border = BorderStroke(2.dp, Color.Black))
            {
                Column(modifier = Modifier.padding(12.dp).fillMaxSize(),Arrangement.Center){
                    Text(text = "Price: ${item.Price}", style = TextStyle(color = Color.Blue, fontSize = 18.sp))
                }
            }

            if (isExpanded){
                Text(text = item.Specifications.toString(), modifier = Modifier.align(Alignment.CenterHorizontally), style = TextStyle(color = Color.Red, fontSize = 18.sp) )
                Text(text = item.TopSpeed.toString(),modifier = Modifier.align(Alignment.CenterHorizontally), style = TextStyle(color = Color.Red, fontSize = 18.sp) )
            }

        }
    }

}
