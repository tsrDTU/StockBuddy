package com.stockbuddy.data.API

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request



class StockInfoRetriever {

    //Example of how to use the functions

    /*
    //My API key, dont get me banned pls ;)
    val apiKey = "API_KEY_HERE"

    //Asynchronic threading so we dont have to halter the entire program while we wait
    val stockData = remember { mutableStateListOf<String>() }
    LaunchedEffect(Unit) {
        //Gives the list to fetchStockData so it returns the result linearly
        fetchStockData(listOf("AAPL", "TSLA", "MSFT","HPQ","fakenews","BLIAQ"), apiKey) { result ->
            //appends to our dataList
            //returns the string: "(name of stock) is worth (price of stock)"
            //incase of error it returns "Error fetching data for (name of stock): (error)
            stockData.add(result)
        }
    }
    //This is how i used it in my project where it printed the strings in a column.
    Column {
        stockData.forEach { data ->
            PrintIt(data)
        }
    }
    */

    //Given a list of stock tickers, it returns the ticker with the added text of what its worth
    fun fetchStockData(stockSymbols: List<String>, apiKey: String, onResult: (String) -> Unit) {
        //starts the asynchronic threading.
        CoroutineScope(Dispatchers.IO).launch {
            //simple forloop for each of the given ticker
            stockSymbols.forEach { stockSymbol ->
                //try catch incase of errors.
                try {
                    //The code template is given by RapidApi
                    val client = OkHttpClient()
                    //datatype can be either JSON or csv, where csv is simple to find price of stock
                    val request = Request.Builder()
                        .url("https://alpha-vantage.p.rapidapi.com/query?function=GLOBAL_QUOTE&symbol=$stockSymbol&datatype=csv")
                        .get()
                        .addHeader("X-RapidAPI-Key", apiKey) //our key
                        .addHeader("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com")
                        .build()

                    val response = client.newCall(request).execute()

                    val responseData = response.body?.string()

                    withContext(Dispatchers.Main) {
                        //here we parse and return the ticker with the stock price
                        val stockPrice = parseStockPrice(responseData)
                        onResult("$stockSymbol is worth ${stockPrice.toDouble()}$")
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        //Error detection simply states what went wrong.
                        onResult("Error fetching data for $stockSymbol: $e")
                    }
                }
            }
        }
    }


    //Assuming the data given is csv format
    fun parseStockPrice(responseData: String?): String {
        //Split data by , since its csv and the price is the 13th value (0indented)
        if (responseData != null) {
            return responseData.split(",")[13]
        }
        //if we didnt get any data return null (should never happen?)
        return "null"

    }
}
