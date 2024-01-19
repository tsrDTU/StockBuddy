package com.stockbuddy

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.stockbuddy.UniversalDef.SettingBar
import com.stockbuddy.UniversalDef.TopBar



@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("RestrictedApi")
//@Preview(name = "Settings")
@Composable
fun SettingsPage(navController: NavHostController) {



    Column {
        TopBar(navController = navController, title = "Settings")


        LazyColumn {
            item {SettingBar(navController, "Setting 1")}
            item {SettingBar(navController, "Setting 2")}
            item {SettingBar(navController, "Setting 3")}
            item {SettingBar(navController, "Setting 4")}
            item {SettingBar(navController, "Setting 5")}
            item {SettingBar(navController, "Setting 6")}
            item {SettingBar(navController, "Setting 7")}
        }
    }

}







