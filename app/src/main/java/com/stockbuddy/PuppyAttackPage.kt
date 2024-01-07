package com.stockbuddy

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.stockbuddy.ui.theme.StockBuddyTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource


//class Stock : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            StockPage(navController)
//        }
//    }
//}

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("RestrictedApi")
@Preview(name = "Stock") // NavController param needs to be commented to see preview
@Composable
fun StockPage() {
//    StockBuddyTheme {
        //val navController = rememberNavController()
        //val currentBackStack by navController.currentBackStackEntryAsState()
        //val currentDestination = currentBackStack?.destination
        //val currentScreen = stockBuddyTabRowScreens.find { it.route == currentDestination?.route } ?: FirstScreen


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
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {}
            LazyColumn {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp)
                            .padding(top = 4.dp, bottom = 4.dp)
                    ) {
                        // Content of the first Box
                        Box(
                            modifier = Modifier
                                .width(370.dp)
                                .background(Color(R.color.stockBackground))
                                .align(Alignment.Center)
                                .padding(8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_rectangle19),
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
                            .height(220.dp)
                            .padding(top = 4.dp, bottom = 4.dp)
                    ) {
                        // Content of the first Box
                        Box(
                            modifier = Modifier
                                .width(370.dp)
                                .background(Color(R.color.stockBackground))
                                .align(Alignment.Center)
                                .padding(8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_rectangle20),
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
                            .height(220.dp)
                            .padding(top = 4.dp, bottom = 4.dp)
                    ) {
                        // Content of the first Box
                        Box(
                            modifier = Modifier
                                .width(370.dp)
                                .background(Color(R.color.stockBackground))
                                .align(Alignment.Center)
                                .padding(8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_rectangle21),
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
                            .height(220.dp)
                            .padding(top = 4.dp, bottom = 4.dp)
                    ) {
                        // Content of the first Box
                        Box(
                            modifier = Modifier
                                .width(370.dp)
                                .background(Color(R.color.stockBackground))
                                .align(Alignment.Center)
                                .padding(8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_rectangle22),
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

            }
}











