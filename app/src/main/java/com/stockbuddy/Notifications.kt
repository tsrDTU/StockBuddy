package com.stockbuddy

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.stockbuddy.UniversalDef.TopBar
import com.stockbuddy.domain.users.ShowUserNotifications
import com.stockbuddy.domain.users.StockViewModel


@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("RestrictedApi")
//@Preview
@Composable
fun NotificationsPage(navController : NavHostController) {
//            topBar = {
//                StockBuddyTabRow(
//                    allScreens = stockBuddyTabRowScreens,
//                    onTabSelected = { newScreen ->
//                        navController
//                        navController.navigate(newScreen.route)
//                    },
//                    currentScreen = currentScreen
//                )
//            }
    Column {
        TopBar(navController = navController, title = "Notifications")

        ShowUserNotifications(StockViewModel(), navController)
        /*
        LazyColumn {
            item {
                NotificationsBox(navController,
                    "Purchase Confirmed",
                    "Today - 12:07",
                    "You bought X amount of X stock for X price")
            }
            item {
                NotificationsBox(navController,
                    "Purchase Confirmed",
                    "Today - 12:07",
                    "You bought X amount of X stock for X price")
            }
            item {
                NotificationsBox(navController,
                    "Purchase Confirmed",
                    "Today - 12:07",
                    "You bought X amount of X stock for X price")
            }
            item {
                NotificationsBox(navController,
                    "Purchase Confirmed",
                    "Today - 12:07",
                    "You bought X amount of X stock for X price")
            }
        }
        */
    }
}








