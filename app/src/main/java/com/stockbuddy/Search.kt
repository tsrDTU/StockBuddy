package com.stockbuddy

import android.annotation.SuppressLint
import android.graphics.Matrix
import android.graphics.RectF
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.stockbuddy.R

//class Search : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            SearchPage()
//        }
//    }
//}

//@Composable
//fun ScrollableList() {
//    val listState = rememberLazyListState()
//
//    LazyColumn(
//        state = listState,
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//    ) {
//        items(50) { index ->
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(50.dp)
//                    .padding(16.dp)
//                    .background(Color.Gray)
//            ) {
//                Text("Item $index", color = Color.White)
//            }
//        }
//    }
//}

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("RestrictedApi")
//@Preview
@Composable
fun SearchPage(navController : NavHostController) {

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
        TopBar(navController = navController, title = "Search")


        LazyColumn {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(46.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 0.dp
                            )
                        )
                        .background(Color.Transparent)
                        .padding(top = 16.dp)
                        .alpha(1f),
                    horizontalArrangement = Arrangement.SpaceBetween // Aligns items at the start and end of the row
                ) {
                    // Left side (Search)
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
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(8.dp)
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







