package com.stockbuddy

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
                            .background(Color(red = 1f, green = 1f, blue = 1f, alpha = 1f))
                            .padding(start = 32.dp)
                            .border(
                                1.dp,
                                Color(
                                    red = 0.007843137718737125f,
                                    green = 0.007843137718737125f,
                                    blue = 0.007843137718737125f,
                                    alpha = 1f
                                ),
                                RoundedCornerShape(
                                    topStart = 4.dp,
                                    topEnd = 4.dp,
                                    bottomStart = 4.dp,
                                    bottomEnd = 4.dp
                                )
                            )
                            //.align(Alignment.Center)
                            .alpha(1f)
                    ) {
                        Text(
                            text = "Search",
                            textAlign = TextAlign.Start,
                            fontSize = 16.sp,
                            textDecoration = TextDecoration.None,
                            letterSpacing = 0.15.sp,
                            lineHeight = 24.sp,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .width(200.dp)
                                .padding(start = 4.dp)
                                .alpha(1f),
                            color = Color(
                                red = 0.4588235318660736f,
                                green = 0.4588235318660736f,
                                blue = 0.4588235318660736f,
                                alpha = 1f
                            ),
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal,
                        )
                    }

                    // Spacer to create space between "Search" and "Filter"
                    Spacer(modifier = Modifier.width(24.dp))

                    // Right side (Filter)
                    Box(
                        modifier = Modifier
                            .width(200.dp)
                            .height(30.dp)
                            .padding(end = 32.dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = 4.dp,
                                    topEnd = 4.dp,
                                    bottomStart = 4.dp,
                                    bottomEnd = 4.dp
                                )
                            )
                            .background(
                                Color(
                                    red = 0.12941177189350128f,
                                    green = 0.12941177189350128f,
                                    blue = 0.12941177189350128f,
                                    alpha = 1f
                                )
                            )
                            .padding(start = 2.dp, top = 2.dp, end = 2.dp, bottom = 2.dp)
                            .alpha(1f)
                    ) {
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
                }
            }


            item {
                val stockData = remember { mutableStateOf("Calling") }
                LaunchedEffect(Unit) {
                    //Gives the list to fetchStockData so it returns the result linearly
                    fetchStockData("MSFT", "c0fdd7bfcbmsh0b58f6101388a65p13d7a8jsnf853cc61748a") { result ->
                        //appends to our dataList
                        //returns the string: "(name of stock) is worth (price of stock)"
                        //incase of error it returns "Error fetching data for (name of stock): (error)
                        stockData.value = result
                    }
                }
                StockBox(navController, "MSFT", stockData.value) }
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
