package com.stockbuddy.data

data class UserData(
    var Emailaddress: String,
    var FirstName: String,
    var LastName: String,
    var UserId: String
)

data class StockData(
    var UserId: String,
    var StockName: String,
    var NumberOfStocks: Int,
    var PurPriceEuro: Double,
    var PurCostEuro: Double,
    var PurDate: String,
    var Sold: Boolean,
    var SellPriceEuro: Double,
    var SellCostEuro: Double,
    var SellDate: String

)