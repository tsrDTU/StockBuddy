package com.stockbuddy.data.csv

import com.opencsv.CSVReader
import com.stockbuddy.domain.model.CompanyListing
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CompanyListingsParser @Inject constructor(): CSVParser<CompanyListing> {
    override suspend fun parse(stream: InputStream): List<CompanyListing> {
        val csvReader = CSVReader(InputStreamReader(stream))
        /*
        It switches the coroutine context to Dispatchers.IO to perform the CSV parsing operation
        in the I/O thread pool, avoiding blocking the main thread.
        */
        return withContext(Dispatchers.IO) {
            csvReader
                /*
                It uses the CSVReader to read all lines from the CSV file, drops the header
                (first line), and then maps each CSV line to a CompanyListing object using
                mapNotNull.
                mapNotNull is used to transform each CSV line into a CompanyListing object,
                filtering out any lines that result in a null value.
                */
                .readAll()
                .drop(1)
                .mapNotNull{line->
                    /*
                    It extracts values from specific columns in the CSV line and uses them to create
                    a CompanyListing object.
                    If any of the required values (name, symbol, exchange) is null,
                    the entire CompanyListing creation is skipped using return@mapNotNull null.
                     */
                    val symbol = line.getOrNull(0)
                    val name = line.getOrNull(1)
                    val exchange = line.getOrNull(2)
                    CompanyListing(
                        name=name?: return@mapNotNull null,
                        symbol=symbol?:return@mapNotNull null,
                        exchange=exchange?: return@mapNotNull null,
                    )

                }
                //It ensures that the CSVReader is closed after reading all lines from the CSV file.
                .also {
                    csvReader.close()
                }
        }
    }

}