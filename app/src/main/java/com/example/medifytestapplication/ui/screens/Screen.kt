package com.example.medifytestapplication.ui.screens

sealed class Screen(val route: String , val name: String) {

    object HomeScreen : Screen("home","HomeScreen")

    object Medicines : Screen("medicine" , "MedicineListScreen")

}
