//package com.stockbuddy.OldVersion
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.compose.currentBackStackEntryAsState
//import androidx.navigation.compose.rememberNavController
//import com.stockbuddy.R
//import com.stockbuddy.ui.theme.StockBuddyTheme
//
//class Notifications : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            NotificationsPage()
//        }
//    }
//}
//
//@OptIn(ExperimentalFoundationApi::class)
//@SuppressLint("RestrictedApi")
//@Preview
//@Composable
//fun NotificationsPage() {
//    StockBuddyTheme {
//        val navController = rememberNavController()
//        val currentBackStack by navController.currentBackStackEntryAsState()
//        val currentDestination = currentBackStack?.destination
//        val currentScreen =
//            stockBuddyTabRowScreens.find { FirstScreen.route == currentDestination?.route } ?: FirstScreen
//
//
//
//
//        Scaffold(
////            topBar = {
////                StockBuddyTabRow(
////                    allScreens = stockBuddyTabRowScreens,
////                    onTabSelected = { newScreen ->
////                        navController
////                        navController.navigate(newScreen.route)
////                    },
////                    currentScreen = currentScreen
////                )
////            }
//        ) { innerPadding ->
//            LazyColumn {
//                item {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(120.dp)
//                            .padding(top = 20.dp, bottom = 4.dp)
//                    ) {
//                        // Content of the first Box
//                        Box(
//                            modifier = Modifier
//                                .width(370.dp)
//                                .height(160.dp)
//                                .background(Color(R.color.stockBackground))
//                                .align(Alignment.TopCenter)
//                                .padding(4.dp),
//                            contentAlignment = Alignment.TopStart
//                        ) {
//                            // Use a Row for the first and second Text fields
//                            Row(
//                                modifier = Modifier.fillMaxWidth(),
//                                verticalAlignment = Alignment.Top,
//                                horizontalArrangement = Arrangement.SpaceBetween
//                            ) {
//                                // First Text (Top Left)
//                                Text(
//                                    text = "Purchase Confirmed",
//                                    color = Color.White, // Set the text color
//                                    fontWeight = FontWeight.Bold // Set the text to bold
//                                )
//
//                                // Second Text (Top Right)
//                                Text(
//                                    text = "Today - 12:07",
//                                    color = Color.White, // Set the text color
//                                    fontWeight = FontWeight.Bold // Set the text to bold
//                                )
//                            }
//
//                            // Third Text (Fills the rest of the space)
//                            Text(
//                                text = "You bought X amount of X stock for X price",
//                                color = Color.White, // Set the text color
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(top = 21.dp)
//                                    .align(Alignment.TopStart),
//                                fontSize = 14.sp
//                            )
//                        }
//                    }
//
//                }
//                item {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(104.dp)
//                            .padding(top = 4.dp, bottom = 4.dp)
//                    ) {
//                        // Content of the first Box
//                        Box(
//                            modifier = Modifier
//                                .width(370.dp)
//                                .height(160.dp)
//                                .background(Color(R.color.stockBackground))
//                                .align(Alignment.TopCenter)
//                                .padding(4.dp),
//                            contentAlignment = Alignment.TopStart
//                        ) {
//                            // Use a Row for the first and second Text fields
//                            Row(
//                                modifier = Modifier.fillMaxWidth(),
//                                verticalAlignment = Alignment.Top,
//                                horizontalArrangement = Arrangement.SpaceBetween
//                            ) {
//                                // First Text (Top Left)
//                                Text(
//                                    text = "Purchase Confirmed",
//                                    color = Color.White, // Set the text color
//                                    fontWeight = FontWeight.Bold // Set the text to bold
//                                )
//
//                                // Second Text (Top Right)
//                                Text(
//                                    text = "Today - 12:07",
//                                    color = Color.White, // Set the text color
//                                    fontWeight = FontWeight.Bold // Set the text to bold
//                                )
//                            }
//
//                            // Third Text (Fills the rest of the space)
//                            Text(
//                                text = "You bought X amount of X stock for X price",
//                                color = Color.White, // Set the text color
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(top = 21.dp)
//                                    .align(Alignment.TopStart),
//                                fontSize = 14.sp
//                            )
//                        }
//                    }
//
//                }
//                item {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(104.dp)
//                            .padding(top = 4.dp, bottom = 4.dp)
//                    ) {
//                        // Content of the first Box
//                        Box(
//                            modifier = Modifier
//                                .width(370.dp)
//                                .height(160.dp)
//                                .background(Color(R.color.stockBackground))
//                                .align(Alignment.TopCenter)
//                                .padding(4.dp),
//                            contentAlignment = Alignment.TopStart
//                        ) {
//                            // Use a Row for the first and second Text fields
//                            Row(
//                                modifier = Modifier.fillMaxWidth(),
//                                verticalAlignment = Alignment.Top,
//                                horizontalArrangement = Arrangement.SpaceBetween
//                            ) {
//                                // First Text (Top Left)
//                                Text(
//                                    text = "Purchase Confirmed",
//                                    color = Color.White, // Set the text color
//                                    fontWeight = FontWeight.Bold // Set the text to bold
//                                )
//
//                                // Second Text (Top Right)
//                                Text(
//                                    text = "Today - 12:07",
//                                    color = Color.White, // Set the text color
//                                    fontWeight = FontWeight.Bold // Set the text to bold
//                                )
//                            }
//
//                            // Third Text (Fills the rest of the space)
//                            Text(
//                                text = "You bought X amount of X stock for X price",
//                                color = Color.White, // Set the text color
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(top = 21.dp)
//                                    .align(Alignment.TopStart),
//                                fontSize = 14.sp
//                            )
//                        }
//                    }
//
//                }
//                item {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(104.dp)
//                            .padding(top = 4.dp, bottom = 4.dp)
//                    ) {
//                        // Content of the first Box
//                        Box(
//                            modifier = Modifier
//                                .width(370.dp)
//                                .height(160.dp)
//                                .background(Color(R.color.stockBackground))
//                                .align(Alignment.TopCenter)
//                                .padding(4.dp),
//                            contentAlignment = Alignment.TopStart
//                        ) {
//                            // Use a Row for the first and second Text fields
//                            Row(
//                                modifier = Modifier.fillMaxWidth(),
//                                verticalAlignment = Alignment.Top,
//                                horizontalArrangement = Arrangement.SpaceBetween
//                            ) {
//                                // First Text (Top Left)
//                                Text(
//                                    text = "Purchase Confirmed",
//                                    color = Color.White, // Set the text color
//                                    fontWeight = FontWeight.Bold // Set the text to bold
//                                )
//
//                                // Second Text (Top Right)
//                                Text(
//                                    text = "Today - 12:07",
//                                    color = Color.White, // Set the text color
//                                    fontWeight = FontWeight.Bold // Set the text to bold
//                                )
//                            }
//
//                            // Third Text (Fills the rest of the space)
//                            Text(
//                                text = "You bought X amount of X stock for X price",
//                                color = Color.White, // Set the text color
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(top = 21.dp)
//                                    .align(Alignment.TopStart),
//                                fontSize = 14.sp
//                            )
//                        }
//                    }
//
//
////            Row(
////                modifier = Modifier
////                    .fillMaxWidth()
////                    .height(100.dp)
////                    .background(Color.Gray)
////                    .padding(16.dp)
////            ) {
////                // First item
////                Text(
////                    text = "Item 1",
////                    color = Color.White,
////                    fontWeight = FontWeight.Bold,
////                    fontSize = 18.sp,
////                    modifier = Modifier
////                        .weight(1f)
////                        .padding(8.dp)
////                )
////
////                // Spacer to create space between items
////                Spacer(modifier = Modifier.width(8.dp))
////
////                // Second item
////                Text(
////                    text = "Item 2",
////                    color = Color.White,
////                    fontWeight = FontWeight.Bold,
////                    fontSize = 18.sp,
////                    modifier = Modifier
////                        .weight(1f)
////                        .padding(8.dp)
////                )
////            }
//
////                item {
////                    Box(
////                        modifier = Modifier
////                            .width(360.dp)
////                            .height(800.dp)
////                            .clip(
////                                RoundedCornerShape(
////                                    topStart = 0.dp,
////                                    topEnd = 0.dp,
////                                    bottomStart = 0.dp,
////                                    bottomEnd = 0.dp
////                                )
////                            )
////                            .background(Color(red = 1f, green = 1f, blue = 1f, alpha = 1f))
////                            .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)
////                            .alpha(1f)
////                    ) {
////
////                        Box(
////                            modifier = Modifier
////                                .width(329.dp)
////                                .height(146.dp)
////                                .padding(8.dp)
////                                .clip(
////                                    RoundedCornerShape(
////                                        topStart = 0.dp,
////                                        topEnd = 0.dp,
////                                        bottomStart = 0.dp,
////                                        bottomEnd = 0.dp
////                                    )
////                                )
////                                .align(Alignment.TopCenter)
////
////                                .background(
////                                    Color(
////                                        red = 0.8509804010391235f,
////                                        green = 0.8509804010391235f,
////                                        blue = 0.8509804010391235f,
////                                        alpha = 1f
////                                    )
////                                )
////                        )
////                    }
//                    StockBuddyNavHost(
//                        navController = navController,
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
