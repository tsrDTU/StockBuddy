package com.stockbuddy.di

import com.stockbuddy.data.csv.CSVParser
import com.stockbuddy.data.csv.CompanyListingsParser
import com.stockbuddy.data.repository.StockRepositoryImpl
import com.stockbuddy.domain.model.CompanyListing
import com.stockbuddy.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingParser(
        companyListingParser:CompanyListingsParser
    ):CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepository: StockRepositoryImpl
    ): StockRepository
}