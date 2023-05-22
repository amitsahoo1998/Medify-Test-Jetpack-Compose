package com.example.medifytestapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medifytestapplication.R
import com.example.medifytestapplication.component.CategoryItem
import com.example.medifytestapplication.component.SearchTextField
import com.example.medifytestapplication.data.MedicineDataSource

@Composable
fun HomeScreens(onNavigateToMedicine: ()-> Unit) {
    val medicineSearchState = remember{ mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Order Medicines",
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 15.dp),
                color = Color(0xFF2F1653),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Row(verticalAlignment = Alignment.CenterVertically){
                Image(painter = painterResource(id = R.drawable.offer), contentDescription = "offer" , modifier = Modifier.size(25.dp) )
                Icon(painter = painterResource(id = R.drawable.ic_cart), contentDescription = "cart", modifier = Modifier.padding(10.dp))
            }
        }
        SearchTextField(modifier = Modifier.padding(horizontal = 15.dp), hints = "eg. Crocin, Ecosprin" , onValueChange = { medicineSearchState.value = it }, value = medicineSearchState.value)
        Text(
            text = "Shop By Category",
            modifier = Modifier.padding(horizontal = 15.dp , vertical = 10.dp),
            color = Color(0xFF2F1653),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        LazyVerticalGrid(columns = GridCells.Fixed(4),
        modifier = Modifier.padding(5.dp)){
            items(MedicineDataSource.category.size){
                CategoryItem(imageUrl = MedicineDataSource.category[it].imageUrl,
                    categoryName = MedicineDataSource.category[it].name, onclick = onNavigateToMedicine)
            }
        }

    }
}