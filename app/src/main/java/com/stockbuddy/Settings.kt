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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.stockbuddy.UniversalDef.SettingBar
import com.stockbuddy.UniversalDef.TopBar

//class Settings : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            SettingsPage()
//        }
//    }
//}

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("RestrictedApi")
//@Preview(name = "Settings")
@Composable
fun SettingsPage(navController: NavHostController) {


//        Scaffold(
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
//        ) { innerPadding ->
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







