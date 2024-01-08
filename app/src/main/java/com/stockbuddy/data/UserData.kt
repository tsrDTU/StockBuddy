package com.stockbuddy.data

data class UserData(
    var emailaddress: String,
    var firstName: String,
    var lastName: String,
    var userId: String
)

data class StockData(
    var UserId: String?,
    var StockName: String?,
    var NumberOfStocks: Int?,
    var PurPriceEuro: Double?,
    var PurCostEuro: Double?,
    var PurDate: String?,
    var Sold: Boolean?,
    var SellPriceEuro: Double?,
    var SellCostEuro: Double?,
    var SellDate: String?

)