package com.stockbuddy

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.stockbuddy.UniversalDef.StockBoxSecond
import com.stockbuddy.UniversalDef.TopBar
import com.stockbuddy.data.API.fetchAndParseStockInfo


var nameOfTicker = "StockExample"
var priceOfSearchedStock = ""
@Composable
fun StockPage(navController: NavHostController) {

    var stockInfo = remember { mutableStateListOf("Calling","Calling","Calling","Calling","Calling") }
    LaunchedEffect(Unit) {
        fetchAndParseStockInfo(nameOfTicker) { result ->
            stockInfo.clear()
            for(info in result){
                stockInfo.add(info)
            }
        }
    }

    priceOfSearchedStock = stockInfo[0]



    Column {
        TopBar(navController = navController, title = "Stock")
        LazyColumn {
        item { StockBoxSecond(navController, nameOfTicker) }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(top = 4.dp, bottom = 4.dp)
            ) {
                // Content of the first Box
                Box(
                    modifier = Modifier
                        .width(dimensionResource(id = R.dimen.DefaultWidth))
                        .height(120.dp)
                        .background(colorResource(id = R.color.regularBox))
                        .align(Alignment.Center)
                        .padding(8.dp)
                        ,
                    contentAlignment = Alignment.Center
                ) {
                    // Third Text (Fills the rest of the space)
                    Text(
                        text = "Amount Owned - Amount",
                        color = Color.White, // Set the text color
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(top = 0.dp)
                            .align(Alignment.Center),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(top = 4.dp, bottom = 4.dp)
            ) {
                // Content of the first Box
                Box(
                    modifier = Modifier
                        .width(dimensionResource(id = R.dimen.DefaultWidth))
                        .height(160.dp)
                        .background(colorResource(id = R.color.regularBox))
                        .align(Alignment.Center)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    // Third Text (Fills the rest of the space)
                    //listOf(price,volume,low,high,changePercent)
                    Text(
                        text =  "Price: ${stockInfo[0]}\n" +
                                "Volume: ${stockInfo[1]}\n" +
                                "Daily low: ${stockInfo[2]}\n" +
                                "Daily high: ${stockInfo[3]}\n" +
                                "Change: ${stockInfo[4]}",
                        color = Color.White, // Set the text color
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(top = 0.dp)
                            .align(Alignment.Center),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }

        item {
            var allSelected by remember { mutableStateOf(true) }
            var yearSelected by remember { mutableStateOf(true) }
            var monthSelected by remember { mutableStateOf(true) }
            var weekSelected by remember { mutableStateOf(true) }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, bottom = 4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .width(dimensionResource(id = R.dimen.DefaultWidth))
                        .height(48.dp)
                        .background(colorResource(id = R.color.regularBox))
                        .clip(RoundedCornerShape(8.dp))
                        .align(Alignment.Center),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    FilterButton(
                        text = "All",
                        isSelected = allSelected,
                        onToggle = { allSelected = it }
                    )

                    FilterButton(
                        text = "Year",
                        isSelected = yearSelected,
                        onToggle = { yearSelected = it }
                    )

                    FilterButton(
                        text = "Month",
                        isSelected = monthSelected,
                        onToggle = { monthSelected = it }
                    )

                    FilterButton(
                        text = "Week",
                        isSelected = weekSelected,
                        onToggle = { weekSelected = it }
                    )
                }
            }
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(top = 4.dp, bottom = 4.dp)
            ) {
                // Content of the first Box
                Box(
                    modifier = Modifier
                        .width(dimensionResource(id = R.dimen.DefaultWidth))

                        .height(160.dp)
                        .background(colorResource(id = R.color.regularBox))
                        .align(Alignment.Center)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    // Third Text (Fills the rest of the space)
                    Text(
                        text = "information",
                        color = Color.White, // Set the text color
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(top = 0.dp)
                            .align(Alignment.Center),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { navController.navigate("tradingPage") },
                    colors = ButtonDefaults.buttonColors(Color.Green.copy(alpha = 0.6f)),
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)

                ) {
                    Text(text = "Buy", color = Color.White, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.width(16.dp)) // Add some space between buttons

                Button(
                    onClick = { navController.navigate("sellStockSelectedStock") },
                    colors = ButtonDefaults.buttonColors(Color.Red.copy(alpha = 0.6f)),
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
//                        .clickable { navController.navigate("notificationsPage")}

                ) {
                    Text(text = "Sell", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }


        }
    }
    }
}


@Composable
fun FilterButton(
    text: String,
    isSelected: Boolean,
    onToggle: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .clickable { onToggle(!isSelected) }
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = if (isSelected) Icons.Default.ToggleOn else Icons.Default.ToggleOff,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

