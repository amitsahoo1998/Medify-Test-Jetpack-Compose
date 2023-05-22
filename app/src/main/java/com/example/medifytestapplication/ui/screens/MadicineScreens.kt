package com.example.medifytestapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medifytestapplication.R
import com.example.medifytestapplication.component.CategoryItem
import com.example.medifytestapplication.component.MedicineItem
import com.example.medifytestapplication.data.MedicineDataSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicineScreens() {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar ={ MedicineTopAppBar() }, content = {
        MedicineGridView(it)
    })
}

@Composable
fun MedicineGridView(it: PaddingValues) {
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        modifier = Modifier.padding(it)){
        items(MedicineDataSource.category[0].medicineList.size){
            MedicineItem(imageUrl = MedicineDataSource.category[0].medicineList[it].imageUrl,
                categoryName = MedicineDataSource.category[0].medicineList[it].name,
                price = MedicineDataSource.category[0].medicineList[it].price,
                onclick = {})
        }
    }
}

@Composable
fun MedicineTopAppBar() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "Medicines",
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 15.dp),
            color = Color(0xFF2F1653),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id = R.drawable.ic_search), contentDescription = "offer" , modifier = Modifier.size(25.dp) )
            Icon(painter = painterResource(id = R.drawable.ic_cart), contentDescription = "cart", modifier = Modifier.padding(10.dp))
        }
    }
}