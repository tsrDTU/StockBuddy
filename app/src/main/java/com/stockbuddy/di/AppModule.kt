package com.stockbuddy.di
//
//
//import android.app.Application
//import androidx.room.Room
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.moshi.MoshiConverterFactory
//import retrofit2.create
//import javax.inject.Singleton
//import com.stockbuddy.data.local.StockDatabase
//import com.stockbuddy.data.remote.dto.StockApi
//
//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//    @Provides
//    @Singleton
//    fun provideStockApi(): StockApi{
//        return Retrofit.Builder()
//            .baseUrl(StockApi.BASE_URL)
//            .addConverterFactory(MoshiConverterFactory.create())
//            .build()
//            .create()
//    }
//
//    @Provides
//    @Singleton
//    fun provideStockDatabase(app:Application): StockDatabase {
//        return Room.databaseBuilder(
//            app,
//            StockDatabase::class.java,
//            "stockdb.db"
//        ).build()
//    }
//
//}