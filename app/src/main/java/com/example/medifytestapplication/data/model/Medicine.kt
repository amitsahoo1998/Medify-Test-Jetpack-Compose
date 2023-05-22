package com.example.medifytestapplication.data.model

data class Medicine(
    val name: String,
    val price: String,
    val imageUrl: String
)
data class Category(
    val name: String,
    val imageUrl: String,
    val medicineList: List<Medicine>
)
