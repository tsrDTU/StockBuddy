package com.stockbuddy.UniversalDef

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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.stockbuddy.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
//@Preview(name="StockBox")
/// title -> the imported name of a stock
fun StockBox (navController : NavHostController, title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
            .clickable {
                navController.navigate("stockPage")
            }
    ) {
        // Content of the first Box

        Box(
            
            modifier = Modifier
                .width(329.dp)//.width(329.dp)
                .height(146.dp)
                .background(colorResource(id = R.color.regularBox))
                .align(Alignment.TopCenter)
                .padding(8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Title",
                color = Color.White // Set the text color
            )
            Row(
                modifier = Modifier
                    .matchParentSize()
                    .matchParentSize()
                    .background(colorResource(id = R.color.regularBox))
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Stock Name
                    Text(
                        text = title,
                        color = Color.White // Set the text color
                        ,style = TextStyle(fontSize = 24.sp),

                    )

                // price
                Box (modifier = Modifier
                    .width(220.dp),
                    contentAlignment = Alignment.CenterEnd
                ){
                    Text(
                        text = "X", // price
                        color = Color.White // Set the text color
                        ,style = TextStyle(fontSize = 24.sp),
                    )
                }


                Spacer(modifier = Modifier.width(12.dp))


                // positive negative or neutral
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .background(colorResource(id = R.color.regularBox))
//                        .clickable { navController.navigate("accountPage") } // Navigate on click
                    ,contentAlignment = Alignment.CenterEnd

                ) {
//                    if (priceChange > 0) {
//                        Image(
//                            painter = painterResource(id = R.drawable.img_color),
//                            contentDescription = null
//                        )
//                    }
//                    else if (priceChange < 0){
//                        Image(
//                            painter = painterResource(id = R.drawable.img_color_red_600),
//                            contentDescription = null
//                        )
//                    }
//                    else {
//                        Image(
//                            painter = painterResource(id = R.drawable.img_color_yellow_600),
//                            contentDescription = null
//                        )
//                    }

                }
            }
        }
    }
}

@Composable
fun StockBoxSecond (navController : NavHostController, title: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
            .clickable {
                navController.navigate("stockPage")
            }
    ) {
        // Content of the first Box

        Box(

            modifier = Modifier
                .width(370.dp)//.width(329.dp)
                .height(146.dp)
                .background(colorResource(id = R.color.regularBox))
                .align(Alignment.TopCenter)
                .padding(8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Title",
                color = Color.White // Set the text color
            )
            Row(
                modifier = Modifier
                    .matchParentSize()
                    .matchParentSize()
                    .background(colorResource(id = R.color.regularBox))
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Stock Name
                Text(
                    text = title,
                    color = Color.White // Set the text color
                    ,style = TextStyle(fontSize = 24.sp),

                    )

                // price
                Box (modifier = Modifier
                    .width(220.dp),
                    contentAlignment = Alignment.CenterEnd
                ){
                    Text(
                        text = "X", // price
                        color = Color.White // Set the text color
                        ,style = TextStyle(fontSize = 24.sp),
                    )
                }


                Spacer(modifier = Modifier.width(12.dp))


                // positive negative or neutral
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .background(colorResource(id = R.color.regularBox))
//                        .clickable { navController.navigate("accountPage") } // Navigate on click
                    ,contentAlignment = Alignment.CenterEnd

                ) {
//                    if (priceChange > 0) {
//                        Image(
//                            painter = painterResource(id = R.drawable.img_color),
//                            contentDescription = null
//                        )
//                    }
//                    else if (priceChange < 0){
//                        Image(
//                            painter = painterResource(id = R.drawable.img_color_red_600),
//                            contentDescription = null
//                        )
//                    }
//                    else {
//                        Image(
//                            painter = painterResource(id = R.drawable.img_color_yellow_600),
//                            contentDescription = null
//                        )
//                    }

                }
            }
        }
    }
}