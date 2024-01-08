//package com.stockbuddy.OldVersion
//
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Money
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.navigation.NavType
//import androidx.navigation.navArgument
//import androidx.navigation.navDeepLink
//import kotlin.collections.listOf
//
//
//interface StockBuddyDestination {
//    val icon: ImageVector
//    val route: String
//}
//
//object FirstScreen : StockBuddyDestination {
//    override val icon: ImageVector
//        get() = TODO("Not yet implemented")
//    override val route: String
//        = "StockBuddy start"
//}
//
//
//object SingleAccount : StockBuddyDestination {
//    // Added for simplicity, this icon will not in fact be used, as SingleAccount isn't
//    // part of the RallyTabRow selection
//    override val icon = Icons.Filled.Money
//    override val route = "single_account"
//    const val accountTypeArg = "account_type"
//    val routeWithArgs = "$route/{$accountTypeArg}"
//    val arguments = listOf(
//        navArgument(accountTypeArg) { type = NavType.StringType }
//    )
//    val deepLinks = listOf(
//        navDeepLink { uriPattern = "rally://$route/{$accountTypeArg}" }
//    )
//}
//
//
//
//val stockBuddyTabRowScreens = listOf(FirstScreen)
