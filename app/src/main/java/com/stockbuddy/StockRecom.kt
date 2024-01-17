package com.stockbuddy

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
