package com.stockbuddy.data.API

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request


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

    //Given a stock ticker, it returns the ticker with the added text of what its worth
    fun fetchStockData(stockSymbol: String, onResult: (String) -> Unit) {
        val apiKey = "c0fdd7bfcbmsh0b58f6101388a65p13d7a8jsnf853cc61748a"
        //starts the asynchronic threading.
        CoroutineScope(Dispatchers.IO).launch {
                //try catch incase of errors.
                try {
                    //The code template is given by RapidApi
                    val client = OkHttpClient()
                    //datatype can be either JSON or csv, where csv is simple to find price of stock
                    val request = Request.Builder()
                        .url("https://alpha-vantage.p.rapidapi.com/query?function=GLOBAL_QUOTE&symbol=$stockSymbol&datatype=json")
                        .get()
                        .addHeader("X-RapidAPI-Key", apiKey) //our key
                        .addHeader("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com")
                        .build()

                    val response = client.newCall(request).execute()

                    val responseData = response.body?.string()
                    withContext(Dispatchers.Main) {
                        //here we parse and return the tickers stock price
                        val stockPrice = parseStockPrice(responseData).toDouble()
                        onResult(stockPrice.toString())
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        //Error detection simply states what went wrong.
                        onResult("Error with $stockSymbol")
                    }

            }
        }
    }

    //Assuming the data given is csv format
    fun parseStockPrice(responseData: String?): String {
        //Our JSON deserializer
        val gson = Gson()
        val jsonObject = gson.fromJson(responseData, JsonObject::class.java)

        //All of the different data we get when searching for a ticker.
        //Currently we only use price.
        val globalQuote = jsonObject.getAsJsonObject("Global Quote")
        val symbol = globalQuote.get("01. symbol").asString
        val open = globalQuote.get("02. open").asString
        val high = globalQuote.get("03. high").asString
        val low = globalQuote.get("04. low").asString
        val price = globalQuote.get("05. price").asString
        val volume = globalQuote.get("06. volume").asString
        val latestTradingDay = globalQuote.get("07. latest trading day").asString
        val previousClose = globalQuote.get("08. previous close").asString
        val change = globalQuote.get("09. change").asString
        val changePercent = globalQuote.get("10. change percent").asString

        return price

    }
    fun fetchAndParseStockInfo(stockSymbol: String, onResult: (List<String>) -> Unit){
        val apiKey = "c0fdd7bfcbmsh0b58f6101388a65p13d7a8jsnf853cc61748a"
        //starts the asynchronic threading.
        CoroutineScope(Dispatchers.IO).launch {
            //try catch incase of errors.
            try {
                //The code template is given by RapidApi
                val client = OkHttpClient()
                //datatype can be either JSON or csv, where csv is simple to find price of stock
                val request = Request.Builder()
                    .url("https://alpha-vantage.p.rapidapi.com/query?function=GLOBAL_QUOTE&symbol=$stockSymbol&datatype=json")
                    .get()
                    .addHeader("X-RapidAPI-Key", apiKey) //our key
                    .addHeader("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com")
                    .build()

                val response = client.newCall(request).execute()

                val responseData = response.body?.string()
                withContext(Dispatchers.Main) {
                    //here we parse and return the tickers stock price
                    //Our JSON deserializer
                    val gson = Gson()
                    val jsonObject = gson.fromJson(responseData, JsonObject::class.java)

                    //All of the different data we get when searching for a ticker.
                    //Currently we only use price.
                    val globalQuote = jsonObject.getAsJsonObject("Global Quote")
                    val symbol = globalQuote.get("01. symbol").asString
                    val open = globalQuote.get("02. open").asString
                    val high = globalQuote.get("03. high").asString
                    val low = globalQuote.get("04. low").asString
                    val price = globalQuote.get("05. price").asString
                    val volume = globalQuote.get("06. volume").asString
                    val latestTradingDay = globalQuote.get("07. latest trading day").asString
                    val previousClose = globalQuote.get("08. previous close").asString
                    val change = globalQuote.get("09. change").asString
                    val changePercent = globalQuote.get("10. change percent").asString
                    val data = listOf("${price.toDouble()}$",volume, "${low.toDouble()}$", "${high.toDouble()}$", changePercent)
                    onResult(data)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    //Error detection simply states what went wrong.

                    onResult(listOf("Error with $stockSymbol","Ran out of API calls","$e","",""))
                }

            }
        }
    }



//TODO: comment my code
    fun searchForStocks(searchInput: String, onResult: (List<String>) -> Unit){
    val apiKey = "c0fdd7bfcbmsh0b58f6101388a65p13d7a8jsnf853cc61748a"

    CoroutineScope(Dispatchers.IO).launch {
            try {
                val client = OkHttpClient()

                val request = Request.Builder()
                    .url("https://alpha-vantage.p.rapidapi.com/query?keywords=$searchInput&function=SYMBOL_SEARCH&datatype=json")
                    .get()
                    .addHeader("X-RapidAPI-Key", apiKey)
                    .addHeader("X-RapidAPI-Host", "alpha-vantage.p.rapidapi.com")
                    .build()

                val response = client.newCall(request).execute()
                val responseData = response.body?.string()

                withContext(Dispatchers.Main) {
                    // Parse the response and extract the stock price
                    if (responseData != null) {
                        onResult(parseSearch(responseData))
                    }

                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    val result = mutableStateListOf<String>()
                    result.add("$searchInput has an error")
                    result.add("$e")
                    onResult(result)
                }
            }
        }
    }
fun parseSearch(jsonString: String): List<String> {
        val gson = Gson()
        val jsonObject = gson.fromJson(jsonString, JsonObject::class.java)

        val bestMatches = jsonObject.getAsJsonArray("bestMatches")

        val parsedResult = mutableStateListOf<String>()

        bestMatches.forEach { item ->
            val result = item.asJsonObject
            val symbol = result.get("1. symbol").asString
            val name = result.get("2. name").asString
            val type = result.get("3. type").asString
            val region = result.get("4. region").asString
            val marketOpen = result.get("5. marketOpen").asString
            val marketClose = result.get("6. marketClose").asString
            val timezone = result.get("7. timezone").asString
            val currency = result.get("8. currency").asString
            val matchScore = result.get("9. matchScore").asString
            parsedResult.add(symbol)
            //("Symbol: $symbol, Name: $name, Type: $type, Region: $region, Market Open: $marketOpen, Market Close: $marketClose, Timezone: $timezone, Currency: $currency, Match Score: $matchScore")

        }
        return parsedResult
    }
