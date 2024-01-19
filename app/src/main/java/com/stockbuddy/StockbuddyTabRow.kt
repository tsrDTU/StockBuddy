package com.stockbuddy


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.stockbuddy.UniversalDef.TopBar


@Composable
fun StockBuddyTabRow(navController : NavHostController


) {
    Column {
        TopBar(navController = navController, title = "Account")


        Surface(
            Modifier
                .height(TabHeight)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(Color(R.color.regularBox))
                        .clip(RoundedCornerShape(8.dp))
                        .align(Alignment.Center),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .height(10.dp)
                            .width(36.dp)
                            .padding(start = 16.dp)
                            .background(Color.Blue)

                    )
                    Spacer(modifier = Modifier.width(200.dp))

                    Box(
                        modifier = Modifier
                            .height(10.dp)
                            .width(20.dp)
                            .background(Color.Blue)

                    )
                    Box(
                        modifier = Modifier
                            .height(10.dp)
                            .width(20.dp)
                            .background(Color.Blue)

                    )
                    Box(
                        modifier = Modifier
                            .height(10.dp)
                            .width(20.dp)
                            .background(Color.Blue)
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                }
            }
        }
    }
}


private val TabHeight = 56.dp

