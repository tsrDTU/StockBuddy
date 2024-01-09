package com.stockbuddy

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.stockbuddy.R

//class History : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            HistoryPage()
//        }
//    }
//}

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("RestrictedApi")
//@Preview(name = "History")
@Composable
fun HistoryPage(navController : NavHostController) {

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
        TopBar(navController = navController, title = "Account")
        LazyColumn {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .padding(top = 20.dp, bottom = 4.dp)
                ) {
                    // Content of the first Box
                    Box(
                        modifier = Modifier
                            .width(370.dp)
                            .height(120.dp)
                            .background(Color(R.color.purple_200))
                            .align(Alignment.TopCenter)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        // Third Text (Fills the rest of the space)
                        Text(
                            text = "Welcome to the app",
                            color = Color.White, // Set the text color
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 0.dp)
                                .align(Alignment.TopStart),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(94.dp)
                        .padding(top = 4.dp, bottom = 4.dp)
                ) {
                    // Content of the first Box
                    Box(
                        modifier = Modifier
                            .width(370.dp)
                            .height(120.dp)
                            .background(Color(R.color.purple_200))
                            .align(Alignment.TopCenter)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        // Third Text (Fills the rest of the space)
                        Text(
                            text = "Welcome to the app",
                            color = Color.White, // Set the text color
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 0.dp)
                                .align(Alignment.TopStart),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(94.dp)
                        .padding(top = 4.dp, bottom = 4.dp)
                ) {
                    // Content of the first Box
                    Box(
                        modifier = Modifier
                            .width(370.dp)
                            .height(120.dp)
                            .background(Color(R.color.purple_200))
                            .align(Alignment.TopCenter)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        // Third Text (Fills the rest of the space)
                        Text(
                            text = "Welcome to the app",
                            color = Color.White, // Set the text color
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 0.dp)
                                .align(Alignment.TopStart),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(94.dp)
                        .padding(top = 4.dp, bottom = 4.dp)
                ) {
                    // Content of the first Box
                    Box(
                        modifier = Modifier
                            .width(370.dp)
                            .height(120.dp)
                            .background(Color(R.color.purple_200))
                            .align(Alignment.TopCenter)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        // Third Text (Fills the rest of the space)
                        Text(
                            text = "Welcome to the app",
                            color = Color.White, // Set the text color
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 0.dp)
                                .align(Alignment.TopStart),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(94.dp)
                        .padding(top = 4.dp, bottom = 4.dp)
                ) {
                    // Content of the first Box
                    Box(
                        modifier = Modifier
                            .width(370.dp)
                            .height(120.dp)
                            .background(Color(R.color.purple_200))
                            .align(Alignment.TopCenter)
                            .padding(8.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        // Third Text (Fills the rest of the space)
                        Text(
                            text = "Welcome to the app",
                            color = Color.White, // Set the text color
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 0.dp)
                                .align(Alignment.TopStart),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }


//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(100.dp)
//                    .background(Color.Gray)
//                    .padding(16.dp)
//            ) {
//                // First item
//                Text(
//                    text = "Item 1",
//                    color = Color.White,
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 18.sp,
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(8.dp)
//                )
//
//                // Spacer to create space between items
//                Spacer(modifier = Modifier.width(8.dp))
//
//                // Second item
//                Text(
//                    text = "Item 2",
//                    color = Color.White,
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 18.sp,
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(8.dp)
//                )
//            }

//                item {
//                    Box(
//                        modifier = Modifier
//                            .width(360.dp)
//                            .height(800.dp)
//                            .clip(
//                                RoundedCornerShape(
//                                    topStart = 0.dp,
//                                    topEnd = 0.dp,
//                                    bottomStart = 0.dp,
//                                    bottomEnd = 0.dp
//                                )
//                            )
//                            .background(Color(red = 1f, green = 1f, blue = 1f, alpha = 1f))
//                            .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)
//                            .alpha(1f)
//                    ) {
//
//                        Box(
//                            modifier = Modifier
//                                .width(329.dp)
//                                .height(146.dp)
//                                .padding(8.dp)
//                                .clip(
//                                    RoundedCornerShape(
//                                        topStart = 0.dp,
//                                        topEnd = 0.dp,
//                                        bottomStart = 0.dp,
//                                        bottomEnd = 0.dp
//                                    )
//                                )
//                                .align(Alignment.TopCenter)
//
//                                .background(
//                                    Color(
//                                        red = 0.8509804010391235f,
//                                        green = 0.8509804010391235f,
//                                        blue = 0.8509804010391235f,
//                                        alpha = 1f
//                                    )
//                                )
//                        )
//                    }

            }
        }
    }
}








