package com.stockbuddy.domain.repository

import com.stockbuddy.domain.model.CompanyListing
import com.stockbuddy.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(

        fetchFromRemote:Boolean,
        query: String


    /* It's wrapped in Resource class to distinguish from success and error cases when
     retrieving data from the API. If it's an error it will post the error message from util.Resource
     and otherwise get the data (if success)

     It's also wrapped in Flow. The Flow is a coroutine and it's used to tell the view model to start
     show/load from the local. The data form local cache is loaded into. If that data is loaded it
     will get a success in the Resource wrapping. At the same time we request data from API and
     updates the UI. Flow is a coroutine that process multiple values over a period of time. Before
     we even load from the database we tell the view model to start showing map the state.

     So app starts loading, it gets data from the cache and the data from the API
     */

    ): Flow<Resource<List<CompanyListing>>>
}