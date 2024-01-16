package com.stockbuddy

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.stockbuddy.UniversalDef.StockBox
import com.stockbuddy.UniversalDef.TopBar

@Composable
@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("RestrictedApi")
fun StockRecommendation(navController: NavController) {
    Column {
        TopBar(navController = navController, title = "Stock")
        LazyColumn{
            item { StockBox(navController = navController, title = "Stock Example")}
            item { StockBox(navController = navController, title = "Stock Example")}
        }
    }


}
