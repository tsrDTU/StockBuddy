package com.stockbuddy.UniversalDef

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.stockbuddy.R


//@Preview(name ="apbar")
@Composable
fun TopBar(navController: NavController, title: String) {
//    TopAppBar(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(56.dp),
//        title = { Text(text = title) },
//        backgroundColor = Color.Cyan
//    )


        TopAppBar(
            Modifier
                .height(56.dp)
                .fillMaxWidth()

        ) {
            Box(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.stockbox_Color))
                    .align(Alignment.Top)

            ) {
                Row(
                    modifier = Modifier
                        .matchParentSize()
                        .matchParentSize()
                        //.background(Color(R.color.purple_200))
                        .align(Alignment.Center),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .weight(0.2f)
                            .height(20.dp)
                            .width(36.dp)
                            .padding(start = 16.dp)
                            .background(colorResource(id = R.color.white))
                            .clickable { navController.navigate("back") }, // Navigate on click
                        contentAlignment = Alignment.Center

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_back),
                            contentDescription = null
                        )
                    }
                    androidx.compose.material3.Text(
                        text = title,
                        color = Color.White // Set the text color

                    )
                    Spacer(modifier = Modifier.weight(1f))

                    Box(
                        modifier = Modifier
                            .weight(0.25f)
                            .height(20.dp)
                            .width(20.dp)
                            .background(colorResource(id = R.color.stockbox_Color))
                            .clickable { navController.navigate("accountPage") } // Navigate on click
                        ,
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_user),
                            contentDescription = null
                        )
                    }
                    Box(
                        modifier = Modifier
                            .weight(0.25f)
                            .height(20.dp)
                            .width(20.dp)
                            .background(colorResource(id = R.color.stockbox_Color))
                            .clickable { navController.navigate("searchBar") } // Navigate on click
                        ,
                        contentAlignment = Alignment.Center


                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_search),
                            contentDescription = null
                        )
                    }
                    Box(
                        modifier = Modifier
                            .weight(0.25f)
                            .height(24.dp)
                            .width(24.dp)
                            .background(colorResource(id = R.color.stockbox_Color))
                            .clickable { navController.navigate("notificationsPage") } // Navigate on click
                        ,
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_notification),
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))

                }
            }
        }

}