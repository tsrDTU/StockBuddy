package com.stockbuddy

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.stockbuddy.domain.stocks.stockPriceFound
import com.stockbuddy.domain.stocks.stockToSearch
import com.stockbuddy.domain.users.purchaseStock
import com.stockbuddy.domain.users.userIdFirestore
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SaveStockInFirestore ( navController : NavHostController) {
    var stockNumber : String
   // var tradingTime = LocalDateTime.now()
    var tradinCost : Double = 18.0
    val stockPrice = stockPriceFound.dropLast(1).toDouble()

    // From  ChatGPT next 3 lines
    val datePattern = Regex("""\b\d{4}-\d{2}-\d{2}\b""")
    val matchResult = datePattern.find(LocalDateTime.now().toString())
    val tradingTime = matchResult?.value.toString()


    Column {
        //  TopBar(navController = navController, title = "Search")


        LazyColumn {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("tradingPage")
                        }
                ) {
                    // Content of the first Box
                    Box(
                        modifier = Modifier
                            .width(329.dp)
                            .height(146.dp)
                            .background(colorResource(id = R.color.gray_300))
                            .align(Alignment.TopCenter)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "Stock: $stockToSearch course value: $stockPrice",
                            color = Color.Black // Set the text color

                        )
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                ) {
                    var input by remember { mutableStateOf("") }
                    var status by remember { mutableStateOf(false) }
                    var items = remember {
                        mutableListOf(
                            "stockNumber"

                            //Tilføj stocks her gennem API
                        )
                    }


                    Scaffold {
                        SearchBar(
                            modifier = Modifier.fillMaxWidth(),
                            query = input,
                            onQueryChange = {
                                input = it
                            },
                            onSearch = {

                                stockNumber = input

                                Log.w("StateFlow", "1 :Number of stocks: $stockNumber $stockToSearch ")
                                val stockNum = stockNumber.toInt()

                             //   val tradTime = tradingTime.toString()
                  //              Log.w("StateFlow", "2 :Number of stocks: $stockNum $stockToSearch ")
                                purchaseStock(userIdFirestore, stockToSearch, stockNum, stockPrice, tradinCost, tradingTime)
                                navController.navigate("notificationsPage")

                            },
                            active = status,
                            onActiveChange = {
                                status = it
                            },
                            placeholder = {

                                Text(text = "Enter number of Stocks to purchase: ")
                            }


                        )

                        {


                            items.forEach {
                                Row(modifier = Modifier
                                    .padding(20.dp)
                                    .clickable { navController.navigate(it) }
                                )
                                {
                                    Icon(
                                        modifier = Modifier
                                            .padding(end = 20.dp),
                                        imageVector = Icons.Default.History,
                                        contentDescription = "history"
                                    )
                                    Text(text = it)
                                }
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(15.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 0.dp
                            )
                        )
                        .background(colorResource(id = R.color.regularBox))
                        .padding(top = 10.dp)
                        .alpha(1f),
                    horizontalArrangement = Arrangement.SpaceBetween // Aligns items at the start and end of the row
                ) {

                }
            }
        }
    }
}

