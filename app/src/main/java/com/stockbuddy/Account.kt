package com.stockbuddy

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.stockbuddy.UniversalDef.TopBar
import com.stockbuddy.domain.users.userFirstname
import com.stockbuddy.domain.users.userLastname


@SuppressLint("RestrictedApi")
//@Preview(name = "Account")
@Composable
fun AccountPage(navController: NavHostController) {




    Column {
        TopBar(navController = navController, title = "Account")


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)

        ) {

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .background(Color.Transparent)
                )
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
                                color = colorResource(id = R.color.regularBox),
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
                        text = "$userFirstname $userLastname",
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
                            .width(dimensionResource(id = R.dimen.DefaultWidth))
                            .height(120.dp)
                            .background(
                                color = colorResource(id = R.color.regularBox),
                                shape = RoundedCornerShape(64.dp)
                            )
                            .align(Alignment.Center)
                            .padding(0.dp)
                            .clickable {
                                navController.navigate("historyPage")
                            }
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
                            .width(dimensionResource(id = R.dimen.DefaultWidth))
                            .height(120.dp)
                            .background(
                                color = colorResource(id = R.color.regularBox),
                                shape = RoundedCornerShape(64.dp) // Adjust the corner radius as needed
                            )
                            .align(Alignment.Center)
                            .padding(0.dp)
                            .clickable {
                                navController.navigate("settingsPage")
                            }
                        ,
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
                            .width(dimensionResource(id = R.dimen.DefaultWidth))
                            .height(120.dp)
                            .background(
                                color = colorResource(id = R.color.regularBox),
                                shape = RoundedCornerShape(64.dp) // Adjust the corner radius as needed
                            )
                            .align(Alignment.Center)
                            .padding(0.dp).clickable {
                                navController.navigate("puppyattackPage")
                            },
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

            }
        }
    }
}











