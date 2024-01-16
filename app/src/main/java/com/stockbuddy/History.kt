package com.stockbuddy

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.stockbuddy.UniversalDef.HistoryBox
import com.stockbuddy.UniversalDef.TopBar
import com.stockbuddy.domain.users.ShowStockHistory
import com.stockbuddy.domain.users.StockViewModel

//class History : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            HistoryPage()
//        }
//    }
//}

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("RestrictedApi")
//@Preview(name = "History")
@Composable
fun HistoryPage(navController : NavHostController) {

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
        TopBar(navController = navController, title = "History")
     //   ShowUserNotifications(NotificationViewModel())
        ShowStockHistory(StockViewModel(),navController )

        LazyColumn {
            item { HistoryBox(navController, "Are you welcome to the app?") }
            item { HistoryBox(navController, "Welcome to the app!") }
            item { HistoryBox(navController, "Welcome to the app you are") }
            item { HistoryBox(navController, "Welcome app! to the are") }
            item { HistoryBox(navController, "Are app welcome to the?") }
        }


    }
}








