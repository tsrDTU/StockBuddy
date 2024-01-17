package com.stockbuddy

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.stockbuddy.UniversalDef.TopBar
import com.stockbuddy.domain.users.purchaseStock
import com.stockbuddy.domain.users.userIdFirestore
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


//class Stock : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            StockPage(navController)
//        }
//    }
//}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("RestrictedApi")
//@Preview(name = "Stock") // NavController param needs to be commented to see preview
@Composable
fun TradingPage(navController : NavHostController) {

    var nbrOfStocksToBuy : Int = 0
    var prsOfStock : Double = priceOfSearchedStock.dropLast(1).toDouble()


    // From  ChatGPT next 3 lines. Modified by Torben
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
    val actTime = LocalDateTime.parse(LocalDateTime.now().toString(), formatter)
    val tradingTime = actTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
  //  Log.w("StateFlow", "1 :Time: $tradingTime  ")


    Column {
        TopBar(navController = navController, title = "Trading")

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyColumn {
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
                                .width(320.dp)
                                .height(80.dp)
                                .background(
                                    color = colorResource(id = R.color.regularBox),
                                    shape = RoundedCornerShape(64.dp)
                                )
                                .align(Alignment.Center)
                                .padding(0.dp)
                        ) {
                            // Third Text (Fills the rest of the space)
                            Text(
                                text = "Buying / Selling",
                                color = Color.White, // Set the text color
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .padding(top = 0.dp)
                                    .align(Alignment.Center),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp)
                            .padding(top = 4.dp, bottom = 4.dp)

                    ) {
                        // Content of the first Box
                        Box(
                            modifier = Modifier
                                .width(dimensionResource(id = R.dimen.DefaultWidth))
                                .height(120.dp)
                                .background(colorResource(id = R.color.regularBox))
                                .align(Alignment.Center)
                                .padding(8.dp),
                            contentAlignment = Alignment.Center,

                            ) {
                            // Third Text (Fills the rest of the space)
                            Text(
                                text = "Stock Name: $nameOfTicker Price: ${priceOfSearchedStock}",
                                color = Color.White, // Set the text color
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .padding(top = 0.dp)
                                    .align(Alignment.CenterStart),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                    }
                }
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(90.dp)
                            .padding(top = 4.dp, bottom = 4.dp)

                    )
                    {
                //    var price by remember { mutableStateOf(0f) }
                      var numOfStocks by remember { mutableStateOf(0) }

                    Box(
                        modifier = Modifier
                            .width(dimensionResource(id = R.dimen.DefaultWidth))
                            .height(80.dp)
                            .background(Color.Gray)
                            .padding(8.dp)
                            .align(Alignment.Center),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Left side (input field)
                            OutlinedTextField(
                             //   value = price.toString(),
                                value = numOfStocks.toString(),
                                onValueChange = {
                                    // Handle input change
                           //         price = it.toFloatOrNull() ?: 0f
                                    numOfStocks = it.toIntOrNull() ?: 0
                                    nbrOfStocksToBuy = numOfStocks
                                },
                                label = { Text("Enter the number stock you want to puchase") },
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Number
                                ),
                                singleLine = true,
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 8.dp)
                            )

                            // Right side (text)
                            Icon(
                                imageVector = Icons.Default.AttachMoney,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
                }
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(top = 0.dp, bottom = 0.dp)
                    ) {

                        Button(
                            onClick = { purchaseStock(userIdFirestore, nameOfTicker, nbrOfStocksToBuy, prsOfStock, 18.0, tradingTime)
                                navController.navigate("notificationsPage")        },

                            colors = ButtonDefaults.buttonColors(Color.Green.copy(alpha = 0.6f)),
                            modifier = Modifier
                                .height(48.dp)
                                .width(320.dp)
                                .align(Alignment.Center)

                        ) {
                            Text(
                                text = "Approve",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                }
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(360.dp)
                            .padding(top = 4.dp, bottom = 4.dp)

                    ) {
                        // Content of the first Box
                        Box(
                            modifier = Modifier
                                .width(dimensionResource(id = R.dimen.DefaultWidth))
                                .height(360.dp)
                                .background(colorResource(id = R.color.regularBox))
                                .align(Alignment.Center)
                                .padding(8.dp),
                            contentAlignment = Alignment.Center,

                            ) {
                            // Third Text (Fills the rest of the space)
                            Text(
                                text = "Details",
                                color = Color.White, // Set the text color
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .padding(top = 0.dp)
                                    .align(Alignment.Center),
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Medium,

                                )
                        }
                    }
                }
            }
        }
    }
}




