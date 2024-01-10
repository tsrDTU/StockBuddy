package com.stockbuddy

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


//@Preview(name ="apbar")
@Composable
fun TopBar(navController : NavHostController, title: String) {
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
                    .background(Color.Blue)
                    .align(Alignment.Top)

            ) {
                Row(
                    modifier = Modifier
                        .matchParentSize()
                        .matchParentSize()
                        .background(Color(R.color.purple_200))
                        .align(Alignment.Center),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .width(36.dp)
                            .padding(start = 16.dp)
                            .background(Color.Blue)
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
                    Spacer(modifier = Modifier.width(200.dp))

                    Box(
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                            .background(Color.Blue)
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
                            .height(20.dp)
                            .width(20.dp)
                            .background(Color.Blue)
                            .clickable { navController.navigate("searchPage") } // Navigate on click
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
                            .height(24.dp)
                            .width(24.dp)
                            .background(Color.Blue)
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