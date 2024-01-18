package com.stockbuddy.UniversalDef

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.stockbuddy.R
import com.stockbuddy.data.API.fetchStockData
import com.stockbuddy.nameOfTicker

@Composable
//@Preview(name="StockBox")
/// title -> the imported name of a stock
fun StockBox (navController: NavController, title: String) {
    val price = remember { mutableStateOf("Calling") }
    LaunchedEffect(Unit) {
        //Gives the list to fetchStockData so it returns the result linearly
        fetchStockData(title) { result ->
            //appends to our dataList
            //returns the string: "(name of stock) is worth (price of stock)"
            //incase of error it returns "Error fetching data for (name of stock): (error)
            price.value = "$result$"
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
            .clickable {
                nameOfTicker = title
                navController.navigate("stockPage")
            }
    ) {
        // Content of the first Box

        Box(
            
            modifier = Modifier
                .width(dimensionResource(id = R.dimen.DefaultWidth))
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
                        text = price.value, // price
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
                .width(dimensionResource(id = R.dimen.DefaultWidth))//.width(dimensionResource(id = R.dimen.DefaultWidth))

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
                        text = "", // price
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
fun StockBoxCustomPrice (navController: NavController, title: String,ticker: String, price: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable {
                nameOfTicker = ticker
                navController.navigate("stockPage")
            }
    ) {
        // Content of the first Box

        Box(

            modifier = Modifier
                .width(dimensionResource(id = R.dimen.DefaultWidth))
//.width(dimensionResource(id = R.dimen.DefaultWidth))
                .padding(6.dp)
                .height(146.dp)
                .align(Alignment.TopCenter),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "Title",
                color = Color.White, // Set the text color
            )
            Row(
                modifier = Modifier
                    .matchParentSize()
                    .matchParentSize()
                    .background(colorResource(id = R.color.topbar_Blue))
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Stock Name
                Text(
                    text = title+"\n"+ticker,
                    color = Color.White // Set the text color
                    ,style = TextStyle(fontSize = 17.sp),
                    modifier = Modifier
                        .padding(6.dp)
                    )
                Spacer(modifier = Modifier
                    .weight(1f)
                )
                // price

                    Text(
                        text = price, // price
                        color = Color.White // Set the text color
                        ,style = TextStyle(fontSize = 24.sp),
                        modifier = Modifier
                            .padding(6.dp)
                    )


                Spacer(modifier = Modifier.width(2.dp))



            }
        }
    }
}