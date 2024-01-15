package com.stockbuddy

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.stockbuddy.UniversalDef.HistoryBox
import com.stockbuddy.UniversalDef.TopBar
import com.stockbuddy.domain.users.NotificationViewModel
import com.stockbuddy.domain.users.ShowStockHistory
import com.stockbuddy.domain.users.ShowUserNotifications
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








