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
                Row() {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(8.dp)


                    ) {

                        ShowUserInformation(UserViewModel(), navController)
                        /*
                        Box(
                            modifier = Modifier
                                .width(329.dp)
                                .height(146.dp)
                                .background(colorResource(id = R.color.regularBox))
                                .align(Alignment.TopCenter)
                                .clickable {
                                    navController.navigate("portfolioPage")
                                },
                            contentAlignment = Alignment.Center

                        ) {


                            Text(
                                text = "Portfolio\nPreview",
                                color = Color.White // Set the text color
                            )


                        }

                         */
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
                        .alpha(1f),
                    horizontalArrangement = Arrangement.SpaceBetween // Aligns items at the start and end of the row
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(800.dp)
                    ) {
                        var input by remember { mutableStateOf("") }
                        var status by remember { mutableStateOf(false) }
                        var items = remember {
                            mutableListOf(
                                "StockPage",
                                "stock2"
                                //Tilføj stocks her gennem API
                            )
                        }
                        Scaffold {

                            SearchBar(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(600.dp),
                                query = input,
                                onQueryChange = {
                                    input = it
                                },
                                onSearch = {
                                    status = false
                                    items.add(input)
                                    //linjen nedenunder skal sende en string til APIen
                                    navController.navigate(input)
                                },
                                active = status,
                                onActiveChange = {
                                    status = it
                                },
                                placeholder = {
                                    Text(text = "Search")
                                },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = "Search Icon"
                                    )
                                },
                                trailingIcon = {
                                    if (status) {
                                        Icon(
                                            modifier = Modifier.clickable {
                                                if (input.isNotEmpty()) {
                                                    input = ""
                                                } else {
                                                    status = false
                                                }
                                            },
                                            imageVector = Icons.Default.Close,
                                            contentDescription = "Close Icon"
                                        )
                                    }
                                },

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
                                                .padding(end = 14.dp),
                                            imageVector = Icons.Default.History,
                                            contentDescription = "history"
                                        )
                                        Text(text = it)
                                    }
                                }}}}







                    }

                    // Spacer to create space between "Search" and "Filter"


                    // Right side (Filter)

                        Text(
                            text = "Filter",
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp,
                            textDecoration = TextDecoration.None,
                            letterSpacing = 1.25.sp,
                            lineHeight = 16.sp,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .alpha(1f)
                                .padding(start = 4.dp),
                            color = Color(red = 1f, green = 1f, blue = 1f, alpha = 1f),
                            fontWeight = FontWeight.Medium,
                            fontStyle = FontStyle.Normal,
                        )
                    }




            item {
                val stockData = remember { mutableStateListOf<String>() }
                stockData.add("Calling")
                LaunchedEffect(Unit) {
                    //Gives the list to fetchStockData so it returns the result linearly
                    fetchStockData(listOf("MSFT"), "c0fdd7bfcbmsh0b58f6101388a65p13d7a8jsnf853cc61748a") { result ->
                        //appends to our dataList
                        //returns the string: "(name of stock) is worth (price of stock)"
                        //incase of error it returns "Error fetching data for (name of stock): (error)
                        stockData[0] = result
                    }
                }
                StockBox(navController, "MSFT", stockData[0]) }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(8.dp)
                        .clickable { navController.navigate("stockPage") } // Navigate on click
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
