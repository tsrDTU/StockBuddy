package com.stockbuddy.data.remote.dto

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query


interface StockApi {

    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apiKey: String = API_KEY
    ): ResponseBody

    companion object {
        const val API_KEY = "8b5fcffc61mshaed4249b719921ap11512ajsn5aff2ed0853e"
        const val BASE_URL ="https://rapidapi.com/"
    }
}