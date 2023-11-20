package com.stockbuddy.data.repository

import com.stockbuddy.data.csv.CSVParser
import com.stockbuddy.data.csv.CompanyListingsParser
import com.stockbuddy.data.local.StockDatabase
import com.stockbuddy.data.mapper.toCompanyListing
import com.stockbuddy.data.mapper.toCompanyListingEntity
import com.stockbuddy.data.remote.dto.StockApi
import com.stockbuddy.domain.model.CompanyListing
import com.stockbuddy.domain.repository.StockRepository
import com.stockbuddy.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


//https://github.com/philipplackner/StockMarketApp
//ChatGPT

/*
The @Singleton annotation suggests that instances of this class should be singletons, meaning there
is only one instance of this class in the application.
The class is named StockRepositoryImpl and implements the StockRepository interface.
The constructor is annotated with @Inject, indicating that dependencies (api and db) will be
provided via dependency injection.
*/

@Singleton
class StockRepositoryImpl @Inject constructor(
    private val api: StockApi,
    private val db: StockDatabase,
    private val companyListingsParser: CSVParser<CompanyListing>
): StockRepository {
    //It initializes a private property dao with the DAO (Data Access Object) obtained from the
    // StockDatabase
    private val dao = db.dao

    //This function is part of the StockRepository interface and is overridden here.
    //It returns a Flow of Resource containing a list of CompanyListing objects.
    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {

        //It creates a Kotlin Flow, which is a type of asynchronous stream that can emit values
        // over time.
        return flow {

            //It emits a loading state with a true value to indicate that the data is being loaded.
            emit(Resource.Loading(true))

            //It queries the local database using the DAO to retrieve a list of company listings
            // based on the provided query.
            val localListings = dao.searchCompanyListing(query)

            //It emits a success state with the locally retrieved data, mapping it to
            //CompanyListing objects.
            emit(Resource.Success(
                data = localListings.map { it.toCompanyListing() }
            ))

            //It checks if the local database is empty and the query is blank, and if
            // fetchFromRemote is false. If these conditions are met, it emits a loading state with
            // false value, indicating that loading is complete, and returns from the flow.
            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote
            if (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }
            val remoteListings = try {
                val response = api.getListings()
                companyListingsParser.parse(response.byteStream())
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }

            remoteListings?.let { listings ->
                dao.clearCompanyListings()
                dao.insertCompanyListings(
                    listings.map { it.toCompanyListingEntity() }
                )

                emit(Resource.Success(data = dao
                    .searchCompanyListing("")
                    .map { it.toCompanyListing() }))
                emit(Resource.Loading(false))

            }
        }
    }
}


