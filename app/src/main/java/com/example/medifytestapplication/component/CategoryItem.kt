package com.example.medifytestapplication.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CategoryItem(imageUrl: String, categoryName: String, onclick: () -> Unit) {
    Surface(modifier = Modifier
        .wrapContentSize()
        .clickable { onclick.invoke() }) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .border(
                        border = BorderStroke(0.5.dp, Color.LightGray),
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center,

                ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = imageUrl
                    ), contentDescription = null,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Text(
                text = categoryName,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                maxLines = 2, lineHeight = 12.sp
            )
        }
    }
}

@Composable
fun MedicineItem(imageUrl: String, categoryName: String,price: String, onclick: () -> Unit) {
    Surface(modifier = Modifier
        .wrapContentSize()
        .padding(6.dp)
        .border(
            border = BorderStroke(0.5.dp, Color.LightGray),
            shape = RoundedCornerShape(8.dp)
        )
        .clickable { onclick.invoke() }) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.Start
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp),
                contentAlignment = Alignment.Center,

                ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = imageUrl
                    ), contentDescription = null,
                    modifier = Modifier.padding(18.dp)
                )
            }
            Text(
                text = categoryName,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                fontSize = 12.sp,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                maxLines = 2, lineHeight = 12.sp
            )
            Text(text = "MRP ₹$price",
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,)
        }
    }
}