package com.stockbuddy

import android.annotation.SuppressLint
import android.graphics.Matrix
import android.graphics.RectF
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.stockbuddy.ui.theme.StockBuddyTheme
import com.stockbuddy.ui.components.StockBuddyTabRow

class Account : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AccountPage()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("RestrictedApi")
@Preview(name = "Account")
@Composable
fun AccountPage() {
    StockBuddyTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen =
            stockBuddyTabRowScreens.find { it.route == currentDestination?.route } ?: FirstScreen




        Scaffold(
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
        ) { innerPadding ->
            LazyColumn {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(top = 20.dp, bottom = 4.dp)
                    ) {
                        // Content of the first Box
                        Box(
                            modifier = Modifier
                                .width(125.dp)
                                .height(240.dp)
                                .background(
                                    color = Color(R.color.stockBackground),
                                    shape = RoundedCornerShape(64.dp)
                                )
                                .align(Alignment.Center)
                                .padding(8.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_ellipse1),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        color = Color.Gray, // Placeholder background color
                                        shape = RoundedCornerShape(64.dp)
                                    ),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(top = 8.dp, bottom = 0.dp)
                    ) {
                    Text(
                        text = "Puppy Pictures",
                        color = Color.Black, // Set the text color
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(top = 0.dp)
                            .align(Alignment.Center),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                }
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
                                .background(
                                    color = Color(R.color.stockBackground),
                                    shape = RoundedCornerShape(64.dp)
                                )
                                .align(Alignment.Center)
                                .padding(0.dp)
                        ) {
                            // Third Text (Fills the rest of the space)
                            Text(
                                text = "Trading History",
                                color = Color.White, // Set the text color
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .padding(top = 0.dp)
                                    .align(Alignment.Center),
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
                            .padding(top = 4.dp, bottom = 4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        // Content of the first Box
                        Box(
                            modifier = Modifier
                                .width(370.dp)
                                .height(120.dp)
                                .background(
                                    color = Color(R.color.stockBackground),
                                    shape = RoundedCornerShape(64.dp) // Adjust the corner radius as needed
                                )
                                .align(Alignment.Center)
                                .padding(0.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            // Third Text (Fills the rest of the space)
                            Text(
                                text = "Settings",
                                color = Color.White, // Set the text color
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .padding(top = 0.dp)
                                    .align(Alignment.Center),
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
                            .padding(top = 4.dp, bottom = 4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        // Content of the first Box
                        Box(
                            modifier = Modifier
                                .width(370.dp)
                                .height(120.dp)
                                .background(
                                    color = Color(R.color.stockBackground),
                                    shape = RoundedCornerShape(64.dp) // Adjust the corner radius as needed
                                )
                                .align(Alignment.Center)
                                .padding(0.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            // Third Text (Fills the rest of the space)
                            Text(
                                text = "Puppy Pictures",
                                color = Color.White, // Set the text color
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .padding(top = 0.dp)
                                    .align(Alignment.Center),
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
                    StockBuddyNavHost(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}









