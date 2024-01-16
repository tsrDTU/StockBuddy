package com.stockbuddy.data.API

import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

fun getStockRecommendations(omxName: String, onResult: (List<Leader>) -> Unit) {
    CoroutineScope(Dispatchers.IO).launch {
        try {
            val client = OkHttpClient()

            val request = Request.Builder()
                .url("https://bb-finance.p.rapidapi.com/market/get-movers?id=$omxName%3AIND&template=INDEX")
                .get()
                .addHeader("X-RapidAPI-Key", "c0fdd7bfcbmsh0b58f6101388a65p13d7a8jsnf853cc61748a")
                .addHeader("X-RapidAPI-Host", "bb-finance.p.rapidapi.com")
                .build()

            val response = client.newCall(request).execute()

            val responseData = response.body?.string()
            withContext(Dispatchers.Main) {
                val parsedData = Gson().fromJson(responseData, Response::class.java).leaders
                onResult(parsedData)
            }


        } catch (e: Exception) {
            println("sumn went wrong")
            onResult(emptyList())
        }
    }
}
data class Response(
    val leaders: List<Leader>
)

data class Leader(
    val securityType: String,
    val symbol: String,
    val exchange: String,
    val country: String,
    val currency: String,
    val resourceType: String,
    val fundamentalDataCurrency: String,
    val resourceSubtype: String,
    val region: String,
    val ticker: String,
    val tickerName: String,
    val template: String,
    val tinyName: String,
    val name: String,
    val watchlist: Boolean,
    val resourceId: String,
    val last: String,
    val netChange: String,
    val lastPriceTime: Long,
    val pctChange1M: String,
    val yearHigh: String,
    val dayHigh: String,
    val volume: Long,
    val yearLow: String,
    val dayLow: String,
    val pctChangeYTD: String,
    val lastPriceAllSessions: String,
    val pctChange: String
)
