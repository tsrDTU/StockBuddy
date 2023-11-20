package com.stockbuddy.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author Aleksander Sonder
 *
 */

@Database(
    entities = [CompanyListingEntity::class],
    version = 1
)
abstract class StockDatabase:RoomDatabase() {

    //Room will use this class for info about database and generate boilerplate code
    abstract val dao: StockDao
}