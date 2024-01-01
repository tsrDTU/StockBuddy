package com.stockbuddy

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.stockbuddy.ui.theme.StockBuddyTheme
import com.stockbuddy.stockBuddyTabRowScreens
import com.stockbuddy.ui.components.StockBuddyTabRow

class MainActivityAlt : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StockBuddyApp()
        }
    }
}


@Composable
fun StockBuddyApp() {
    StockBuddyTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen =
            stockBuddyTabRowScreens.find {it.route == currentDestination?.route} ?: FirstScreen



    Scaffold(
        topBar = {
            StockBuddyTabRow(
                allScreens = stockBuddyTabRowScreens,
                onTabSelected = { newScreen ->
                    navController
                    navController.navigate(newScreen.route)
                },
                currentScreen = currentScreen
            )
        }
            ) { innerPadding ->
                StockBuddyNavHost(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding)
                )
            }

        }
}
