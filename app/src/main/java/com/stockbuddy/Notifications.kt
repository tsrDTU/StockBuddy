package com.stockbuddy

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.stockbuddy.UniversalDef.NotificationsBox
import com.stockbuddy.UniversalDef.TopBar
import com.stockbuddy.domain.users.NotificationViewModel
import com.stockbuddy.domain.users.ShowUserNotifications
import com.stockbuddy.domain.users.selectUserInFirestore


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
        selectUserInFirestore("bd")
        ShowUserNotifications(NotificationViewModel())
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








