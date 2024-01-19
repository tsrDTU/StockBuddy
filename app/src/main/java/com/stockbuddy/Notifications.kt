package com.stockbuddy

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.stockbuddy.UniversalDef.TopBar
import com.stockbuddy.domain.users.ShowUserNotifications
import com.stockbuddy.domain.users.StockViewModel


@SuppressLint("RestrictedApi")
//@Preview
@Composable
fun NotificationsPage(navController : NavHostController) {


    Column {
        TopBar(navController = navController, title = "Notifications")

        ShowUserNotifications(StockViewModel(), navController)

    }
}








