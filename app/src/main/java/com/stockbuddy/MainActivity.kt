package com.stockbuddy

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.stockbuddy.domain.users.UserExistViewModel
import com.stockbuddy.ui.theme.StockBuddyTheme


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StockBuddyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Set up the navigation controller
                    val navController = rememberNavController()

                    // Set up the navigation host
                    NavHost(
                        navController = navController,
                        startDestination = "StartUpPage"
                    ) {

                        composable("startUpPage") { StartUpPage(navController) } //0
                        composable("homePage") { HomePage(navController) } //1
                        composable("stockPage") { StockPage(navController) } //2
                        composable("searchPage") { SearchPage(navController) } //3
                        composable("settingsPage") { SettingsPage(navController) } //4
                        composable("historyPage") { HistoryPage(navController) } //5
                        composable("portfolioPage") { PortfolioPage(navController) } //6
                        composable("accountPage") { AccountPage(navController) } //7
                        composable("notificationsPage") { NotificationsPage(navController) } //8
                        composable("tradingPage") { TradingPage(navController) } //9
                        composable("puppyattackPage") { PuppyAttackPage(navController) } //10
                        composable("newUser") { NewUser(navController) } //11
                        composable("saveStockInFirestore") { SaveStockInFirestore(navController) } //12
                        composable("back") { navController.navigateUp() } // back button
                        composable("backToStart") {navController.popBackStack(navController.graph.startDestinationId, inclusive = false) }
                    }
                }
            }
        }
    }
}
