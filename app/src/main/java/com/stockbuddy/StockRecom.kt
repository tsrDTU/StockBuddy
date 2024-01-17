package com.stockbuddy

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.stockbuddy.UniversalDef.StockBox
import com.stockbuddy.UniversalDef.StockBoxCustomPrice
import com.stockbuddy.UniversalDef.TopBar
import com.stockbuddy.data.API.Leader
import com.stockbuddy.data.API.getStockRecommendations

@Composable
@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("RestrictedApi")
fun StockRecommendation(navController: NavController) {
    Column {
        TopBar(navController = navController, title = "OMX top dawgs")
        val stockData = remember { mutableStateListOf<Leader>() }
        LaunchedEffect(Unit) {
            //Gives the list to fetchStockData so it returns the result linearly
            getStockRecommendations("INDU") { result ->
                for(stock in result){
                    stockData.add(stock)
                }
            }
        }
        //stock.name+","+stock.symbol+","+stock.last
        LazyColumn{
            for(stock in stockData){
                item { StockBoxCustomPrice(navController,stock.name,stock.symbol,stock.last) }
            }
        }
    }


}
