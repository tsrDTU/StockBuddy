package com.stockbuddy

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.stockbuddy.UniversalDef.StockBox
import com.stockbuddy.UniversalDef.StockBoxCustomPrice
import com.stockbuddy.UniversalDef.TopBar
import com.stockbuddy.data.API.*
import com.stockbuddy.domain.users.ShowUserInformation
import com.stockbuddy.domain.users.UserViewModel

//@Preview(name = "Home")
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavHostController) {
    val stockData = remember { mutableStateListOf<Leader>() }
    Column {
        TopBar(navController = navController, title = "Home")

        LazyColumn {
            item {
                Row() {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(165.dp)
                            .padding(start = 8.dp, end = 8.dp),
                        contentAlignment = Alignment.TopCenter


                    ) {
                        ShowUserInformation(UserViewModel(), navController)
                    }
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 0.dp
                            )
                        )
                        .background(Color.Transparent)
                        .alpha(1f)
                        .padding(start = 8.dp, end = 8.dp),

                    //horizontalArrangement = Arrangement.Center // Aligns items at the start and end of the row
                ) {
                    // Search bar
                    Box(
                        modifier = Modifier
                            .height(30.dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = 4.dp,
                                    topEnd = 4.dp,
                                    bottomStart = 4.dp,
                                    bottomEnd = 4.dp
                                )
                            )
                            .clickable {navController.navigate("searchBar")}
                            .padding(start = 12.dp, end = 12.dp)
                            .background(colorResource(id = R.color.black)),
                        contentAlignment = Alignment.Center,

                    ) {
                        Text(
                            text = "Search",
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            textDecoration = TextDecoration.None,
                            letterSpacing = 0.15.sp,
                            lineHeight = 24.sp,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .width(dimensionResource(id = R.dimen.DefaultWidth))
                                .alpha(1f)
                                .background(colorResource(id = R.color.black)),
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                            color = Color.White,
                        )
                    }
                }
            }
//
        }
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
