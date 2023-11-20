package com.stockbuddy.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

// Annotations are only used in the data layer as they come from a data layer library, so if we want
// to change eg. the database we only have to change in the data layer

@Entity
data class CompanyListingEntity(
    val name: String,
    val symbol: String,
    val exchange: String,

    /* Used for distinguish between different entities. Room will automatically generate unique
    identifiers */
    @PrimaryKey val id: Int? = null
)
