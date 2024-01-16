package com.stockbuddy.util

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.stockbuddy.data.API.fetchStockData


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun searchBar(navController: NavHostController){
        var input by remember { mutableStateOf("") }
        var status by remember { mutableStateOf(false) }
        var items = remember {
            mutableListOf(
                "AAPL",
                "MSFT",
                "HPQ"
            //Tilføj stocks her gennem API
            )
        }
        Scaffold{
            SearchBar(
                modifier = Modifier.fillMaxWidth(),
                query = input,
                onQueryChange = {
                    input = it
                },
                onSearch ={
                    status = false
                    items.add(input)
                    //Global variable, burde ændres til it
                    navController.navigate("StockPage")
                },
                active = status,
                onActiveChange ={
                    status = it
                },
                placeholder ={
                    Text(text = "Search")
                },
                leadingIcon ={
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                },
                trailingIcon = {
                    if(status) {
                        Icon(
                            modifier = Modifier.clickable {
                                if(input.isNotEmpty()){
                                        input = ""
                                    }
                                else{status = false}
                            },
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close Icon"
                        )
                    }
                },
                
            )
            {
                items.forEach{
                    Row(modifier = Modifier
                        .padding(20.dp)
                        .clickable { navController.navigate("StockPage") }
                    )
                    {
                        Icon(
                            modifier = Modifier
                                .padding(end = 14.dp),
                            imageVector = Icons.Default.History,
                            contentDescription = "history"
                        )
                        Text(text = it)
                        val stockData = remember { mutableStateListOf<String>() }
                        stockData.add("Calling")
                        LaunchedEffect(Unit) {
                            //Gives the list to fetchStockData so it returns the result linearly
                            fetchStockData(listOf(it), "c0fdd7bfcbmsh0b58f6101388a65p13d7a8jsnf853cc61748a") { result ->
                                //appends to our dataList
                                //returns the string: "(name of stock) is worth (price of stock)"
                                //incase of error it returns "Error fetching data for (name of stock): (error)
                                stockData[0] = result
                            }
                        }
                        var stockInfo = stockData[0]
                    }
                }
            }
        }
    }

