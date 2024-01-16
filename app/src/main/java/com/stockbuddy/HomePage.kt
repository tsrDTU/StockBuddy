package com.stockbuddy

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.stockbuddy.UniversalDef.StockBox
import com.stockbuddy.UniversalDef.StockBoxSecond
import com.stockbuddy.UniversalDef.TopBar
import com.stockbuddy.data.API.*
import com.stockbuddy.domain.users.ShowUserInformation
import com.stockbuddy.domain.users.UserViewModel

//@Preview(name = "Home")
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavHostController) {
//        Scaffold(
//            topBar = {
//                StockBuddyTabRow(
//                    allScreens = stockBuddyTabRowScreens,
//                    onTabSelected = { newScreen ->
//                        navController
//                        navController.navigate(newScreen.route)
//                    },
//                    currentScreen = currentScreen
//                )
//            }
//        ) { innerPadding ->

    Column {
        TopBar(navController = navController, title = "Home")

        LazyColumn {
            item {
                val stockData = remember { mutableStateOf("Calling") }
                LaunchedEffect(Unit) {
                    //Gives the list to fetchStockData so it returns the result linearly
                    fetchStockData("MSFT") { result ->
                        //appends to our dataList
                        //returns the string: "(name of stock) is worth (price of stock)"
                        //incase of error it returns "Error fetching data for (name of stock): (error)
                        stockData.value = result
                    }
                }
                StockBox(navController, "MSFT") }
            item {
                StockBox(navController, "AAPL")
            }
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
                            .background(colorResource(id = R.color.regularBox))
                            .align(Alignment.TopCenter)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "Trading Example",
                            color = Color.White // Set the text color

                        )
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("notificationsPage")
                        }
                ) {
                    // Content of the first Box
                    Box(
                        modifier = Modifier
                            .width(329.dp)
                            .height(146.dp)
                            .background(colorResource(id = R.color.regularBox))
                            .align(Alignment.TopCenter)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "Notifications Example",
                            color = Color.White // Set the text color

                        )
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("settingsPage")
                        }
                ) {
                    // Content of the first Box
                    Box(
                        modifier = Modifier
                            .width(329.dp)
                            .height(146.dp)
                            .background(colorResource(id = R.color.regularBox))
                            .align(Alignment.TopCenter)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "Settings Example",
                            color = Color.White // Set the text color

                        )
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("puppyattackPage")
                        }
                ) {
                    // Content of the first Box
                    Box(
                        modifier = Modifier
                            .width(329.dp)
                            .height(146.dp)
                            .background(colorResource(id = R.color.regularBox))
                            .align(Alignment.TopCenter)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "Puppy Example",
                            color = Color.White // Set the text color

                        )
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("searchPage")
                        }
                ) {
                    // Content of the first Box
                    Box(
                        modifier = Modifier
                            .width(329.dp)
                            .height(146.dp)
                            .background(colorResource(id = R.color.regularBox))
                            .align(Alignment.TopCenter)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "Search Example",
                            color = Color.White // Set the text color

                        )
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(8.dp).clickable {
                            navController.navigate("stockPage")
                        }
                ) {
                    // Content of the first Box
                    Box(
                        modifier = Modifier
                            .width(329.dp)
                            .height(146.dp)
                            .background(colorResource(id = R.color.regularBox))
                            .align(Alignment.TopCenter)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "Stock Example",
                            color = Color.White // Set the text color

                        )
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("stockPage")
                        }
                ) {
                    // Content of the first Box
                    Box(
                        modifier = Modifier
                            .width(329.dp)
                            .height(146.dp)
                            .background(colorResource(id = R.color.regularBox))
                            .align(Alignment.TopCenter)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "Stock Example",
                            color = Color.White // Set the text color

                        )
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("stockPage")
                        }
                ) {
                    // Content of the first Box
                    Box(
                        modifier = Modifier
                            .width(329.dp)
                            .height(146.dp)
                            .background(colorResource(id = R.color.regularBox))
                            .align(Alignment.TopCenter)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "Stock Example",
                            color = Color.White // Set the text color

                        )
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("stockPage")
                        }
                ) {
                    // Content of the first Box
                    Box(
                        modifier = Modifier
                            .width(329.dp)
                            .height(146.dp)
                            .background(colorResource(id = R.color.regularBox))
                            .align(Alignment.TopCenter)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "Stock Example",
                            color = Color.White // Set the text color

                        )
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("stockPage")
                        }
                ) {
                    // Content of the first Box
                    Box(
                        modifier = Modifier
                            .width(329.dp)
                            .height(146.dp)
                            .background(colorResource(id = R.color.regularBox))
                            .align(Alignment.TopCenter)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "Stock Example",
                            color = Color.White // Set the text color

                        )
                    }
                }
            }
        }
    }
}
