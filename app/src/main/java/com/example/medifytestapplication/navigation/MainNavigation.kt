package com.example.medifytestapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.medifytestapplication.ui.screens.HomeScreens
import com.example.medifytestapplication.ui.screens.MedicineScreens
import com.example.medifytestapplication.ui.screens.Screen

const val MEDIFY_NAV_HOST_ROUTE = "app-main-route"


@Composable
fun MainNavigation() {

    val navController = rememberNavController()

    NavHost(navController, startDestination = Screen.HomeScreen.route , route = MEDIFY_NAV_HOST_ROUTE){
        composable(Screen.HomeScreen.route){
            HomeScreens(onNavigateToMedicine = {navController.navigateToMedicineScreen()})
        }

        composable(Screen.Medicines.route){
            MedicineScreens()
        }
    }
}

fun NavController.navigateToMedicineScreen() = navigate(Screen.Medicines.route)