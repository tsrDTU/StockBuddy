//package com.stockbuddy.OldVersion
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.alpha
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.text.style.TextDecoration
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import com.stockbuddy.ui.theme.StockBuddyTheme
//import com.stockbuddy.R
//
//
////class MainActivityAlt : ComponentActivity() {
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////
////        setContent {
////            MainPage(navController)
////        }
////    }
////}
//
////sealed class Screen(val route: String) {
////    object HomeScreen : Screen("home")
////    object StockPage : Screen("stockPage")
////}
//
//@OptIn(ExperimentalFoundationApi::class)
//@SuppressLint("RestrictedApi")
////@Preview
//@Composable
//fun MainPage(navController : NavHostController) {
//    StockBuddyTheme {
//        //val navController = rememberNavController()
//        //val currentBackStack by navController.currentBackStackEntryAsState()
//        //val currentDestination = currentBackStack?.destination
//        //val currentScreen = stockBuddyTabRowScreens.find { it.route == currentDestination?.route } ?: FirstScreen
//
//
//
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {}
////            NavHost(
////                navController = navController,
////                startDestination = "home"
////            ) {
////                composable("home") { MainActivityAlt() }
////                composable("stockPage") { StockPage(navController) }
////            }
//
////        Scaffold(
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
////        ) { innerPadding ->
//            LazyColumn {
//                item {
//                    Row() {
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(150.dp)
//                                .padding(8.dp)
//
//
//                        ) {
//                            // Content of the second Box
//                            Box(
//                                modifier = Modifier
//                                    .width(329.dp)
//                                    .height(146.dp)
//                                    .background(Color(R.color.stockBackground))
//                                    .align(Alignment.TopCenter)
//                                    .clickable {navController.navigate("stockPage")},
//                                contentAlignment = Alignment.Center
//
//                            ) {
//                                Text(
//                                    text = "Portfolio\nPreview",
//                                    color = Color.White // Set the text color
//                                )
//                            }
//                        }
//                    }
//                }
//                item {
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(30.dp)
//                            .clip(
//                                RoundedCornerShape(
//                                    topStart = 0.dp,
//                                    topEnd = 0.dp,
//                                    bottomStart = 0.dp,
//                                    bottomEnd = 0.dp
//                                )
//                            )
//                            .background(Color.Transparent)
//                            .alpha(1f),
//                        horizontalArrangement = Arrangement.SpaceBetween // Aligns items at the start and end of the row
//                    ) {
//                        // Left side (Search)
//                        Box(
//                            modifier = Modifier
//                                .height(30.dp)
//                                .clip(
//                                    RoundedCornerShape(
//                                        topStart = 4.dp,
//                                        topEnd = 4.dp,
//                                        bottomStart = 4.dp,
//                                        bottomEnd = 4.dp
//                                    )
//                                )
//                                .background(Color(red = 1f, green = 1f, blue = 1f, alpha = 1f))
//                                .padding(start = 32.dp)
//                                .border(
//                                    1.dp,
//                                    Color(
//                                        red = 0.007843137718737125f,
//                                        green = 0.007843137718737125f,
//                                        blue = 0.007843137718737125f,
//                                        alpha = 1f
//                                    ),
//                                    RoundedCornerShape(
//                                        topStart = 4.dp,
//                                        topEnd = 4.dp,
//                                        bottomStart = 4.dp,
//                                        bottomEnd = 4.dp
//                                    )
//                                )
//                                //.align(Alignment.Center)
//                                .alpha(1f)
//                        ) {
//                            Text(
//                                text = "Search",
//                                textAlign = TextAlign.Start,
//                                fontSize = 16.sp,
//                                textDecoration = TextDecoration.None,
//                                letterSpacing = 0.15.sp,
//                                lineHeight = 24.sp,
//                                overflow = TextOverflow.Ellipsis,
//                                modifier = Modifier
//                                    .align(Alignment.CenterStart)
//                                    .width(200.dp)
//                                    .padding(start = 4.dp)
//                                    .alpha(1f),
//                                color = Color(
//                                    red = 0.4588235318660736f,
//                                    green = 0.4588235318660736f,
//                                    blue = 0.4588235318660736f,
//                                    alpha = 1f
//                                ),
//                                fontWeight = FontWeight.Normal,
//                                fontStyle = FontStyle.Normal,
//                            )
//                        }
//
//                        // Spacer to create space between "Search" and "Filter"
//                        Spacer(modifier = Modifier.width(24.dp))
//
//                        // Right side (Filter)
//                        Box(
//                            modifier = Modifier
//                                .width(200.dp)
//                                .height(30.dp)
//                                .padding(end = 32.dp)
//                                .clip(
//                                    RoundedCornerShape(
//                                        topStart = 4.dp,
//                                        topEnd = 4.dp,
//                                        bottomStart = 4.dp,
//                                        bottomEnd = 4.dp
//                                    )
//                                )
//                                .background(
//                                    Color(
//                                        red = 0.12941177189350128f,
//                                        green = 0.12941177189350128f,
//                                        blue = 0.12941177189350128f,
//                                        alpha = 1f
//                                    )
//                                )
//                                .padding(start = 2.dp, top = 2.dp, end = 2.dp, bottom = 2.dp)
//                                .alpha(1f)
//                        ) {
//                            Text(
//                                text = "Filter",
//                                textAlign = TextAlign.Center,
//                                fontSize = 16.sp,
//                                textDecoration = TextDecoration.None,
//                                letterSpacing = 1.25.sp,
//                                lineHeight = 16.sp,
//                                overflow = TextOverflow.Ellipsis,
//                                modifier = Modifier
//                                    .alpha(1f)
//                                    .padding(start = 4.dp),
//                                color = Color(red = 1f, green = 1f, blue = 1f, alpha = 1f),
//                                fontWeight = FontWeight.Medium,
//                                fontStyle = FontStyle.Normal,
//                            )
//                        }
//                    }
//                }
//
//
//                item {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(100.dp)
//                            .padding(8.dp)
//                    ) {
//                        // Content of the first Box
//                        Box(
//                            modifier = Modifier
//                                .width(329.dp)
//                                .height(146.dp)
//                                .background(Color(R.color.stockBackground))
//                                .align(Alignment.TopCenter)
//                                .padding(8.dp),
//                            contentAlignment = Alignment.CenterStart
//                        ) {
//                            Text(
//                                text = "Stock Example",
//                                color = Color.White // Set the text color
//
//                            )
//                        }
//                    }
//                }
//                item {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(100.dp)
//                            .padding(8.dp)
//                            .clickable { navController.navigate("Stock") } // Navigate on click
//                    ) {
//                        // Content of the first Box
//                        Box(
//                            modifier = Modifier
//                                .width(329.dp)
//                                .height(146.dp)
//                                .background(Color(R.color.stockBackground))
//                                .align(Alignment.TopCenter)
//                                .padding(8.dp),
//                            contentAlignment = Alignment.CenterStart
//                        ) {
//                            Text(
//                                text = "Stock Example",
//                                color = Color.White // Set the text color
//
//                            )
//                        }
//                    }
//                }
//                item {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(100.dp)
//                            .padding(8.dp)
//                    ) {
//                        // Content of the first Box
//                        Box(
//                            modifier = Modifier
//                                .width(329.dp)
//                                .height(146.dp)
//                                .background(Color(R.color.stockBackground))
//                                .align(Alignment.TopCenter)
//                                .padding(8.dp),
//                            contentAlignment = Alignment.CenterStart
//                        ) {
//                            Text(
//                                text = "Stock Example",
//                                color = Color.White // Set the text color
//
//                            )
//                        }
//                    }
//                }
//                item {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(100.dp)
//                            .padding(8.dp)
//                    ) {
//                        // Content of the first Box
//                        Box(
//                            modifier = Modifier
//                                .width(329.dp)
//                                .height(146.dp)
//                                .background(Color(R.color.stockBackground))
//                                .align(Alignment.TopCenter)
//                                .padding(8.dp),
//                            contentAlignment = Alignment.CenterStart
//                        ) {
//                            Text(
//                                text = "Stock Example",
//                                color = Color.White // Set the text color
//
//                            )
//                        }
//                    }
//                }
//                item {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(100.dp)
//                            .padding(8.dp)
//                    ) {
//                        // Content of the first Box
//                        Box(
//                            modifier = Modifier
//                                .width(329.dp)
//                                .height(146.dp)
//                                .background(Color(R.color.stockBackground))
//                                .align(Alignment.TopCenter)
//                                .padding(8.dp),
//                            contentAlignment = Alignment.CenterStart
//                        ) {
//                            Text(
//                                text = "Stock Example",
//                                color = Color.White // Set the text color
//
//                            )
//                        }
//                    }
//                }
//                item {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(100.dp)
//                            .padding(8.dp)
//                    ) {
//                        // Content of the first Box
//                        Box(
//                            modifier = Modifier
//                                .width(329.dp)
//                                .height(146.dp)
//                                .background(Color(R.color.stockBackground))
//                                .align(Alignment.TopCenter)
//                                .padding(8.dp),
//                            contentAlignment = Alignment.CenterStart
//                        ) {
//                            Text(
//                                text = "Stock Example",
//                                color = Color.White // Set the text color
//
//                            )
//                        }
//                    }
//                }
//                item {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(100.dp)
//                            .padding(8.dp)
//                    ) {
//                        // Content of the first Box
//                        Box(
//                            modifier = Modifier
//                                .width(329.dp)
//                                .height(146.dp)
//                                .background(Color(R.color.stockBackground))
//                                .align(Alignment.TopCenter)
//                                .padding(8.dp),
//                            contentAlignment = Alignment.CenterStart
//                        ) {
//                            Text(
//                                text = "Stock Example",
//                                color = Color.White // Set the text color
//
//                            )
//                        }
//                    }
//                }
//                item {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(100.dp)
//                            .padding(8.dp)
//                    ) {
//                        // Content of the first Box
//                        Box(
//                            modifier = Modifier
//                                .width(329.dp)
//                                .height(146.dp)
//                                .background(Color(R.color.stockBackground))
//                                .align(Alignment.TopCenter)
//                                .padding(8.dp),
//                            contentAlignment = Alignment.CenterStart
//                        ) {
//                            Text(
//                                text = "Stock Example",
//                                color = Color.White // Set the text color
//
//                            )
//                        }
//                    }
//                }
//                item {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(100.dp)
//                            .padding(8.dp)
//                    ) {
//                        // Content of the first Box
//                        Box(
//                            modifier = Modifier
//                                .width(329.dp)
//                                .height(146.dp)
//                                .background(Color(R.color.stockBackground))
//                                .align(Alignment.TopCenter)
//                                .padding(8.dp),
//                            contentAlignment = Alignment.CenterStart
//                        ) {
//                            Text(
//                                text = "Stock Example",
//                                color = Color.White // Set the text color
//
//                            )
//                        }
//                    }
//                }
//                item {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(100.dp)
//                            .padding(8.dp)
//                    ) {
//                        // Content of the first Box
//                        Box(
//                            modifier = Modifier
//                                .width(329.dp)
//                                .height(146.dp)
//                                .background(Color(R.color.stockBackground))
//                                .align(Alignment.TopCenter)
//                                .padding(8.dp),
//                            contentAlignment = Alignment.CenterStart
//                        ) {
//                            Text(
//                                text = "Stock Example",
//                                color = Color.White // Set the text color
//
//                            )
//                        }
//                    }
//                }
//                item {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(100.dp)
//                            .padding(8.dp)
//                    ) {
//                        // Content of the first Box
//                        Box(
//                            modifier = Modifier
//                                .width(329.dp)
//                                .height(146.dp)
//                                .background(Color(R.color.stockBackground))
//                                .align(Alignment.TopCenter)
//                                .padding(8.dp),
//                            contentAlignment = Alignment.CenterStart
//                        ) {
//                            Text(
//                                text = "Stock Example",
//                                color = Color.White // Set the text color
//
//                            )
//                        }
//                    }
//                }
//                item {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(100.dp)
//                            .padding(8.dp)
//                    ) {
//                        // Content of the first Box
//                        Box(
//                            modifier = Modifier
//                                .width(329.dp)
//                                .height(146.dp)
//                                .background(Color(R.color.stockBackground))
//                                .align(Alignment.TopCenter)
//                                .padding(8.dp),
//                            contentAlignment = Alignment.CenterStart
//                        ) {
//                            Text(
//                                text = "Stock Example",
//                                color = Color.White // Set the text color
//
//                            )
//                        }
//                    }
//                }
//            }
//
//        }
//
//    }
//
//
//
//
//
//
//
