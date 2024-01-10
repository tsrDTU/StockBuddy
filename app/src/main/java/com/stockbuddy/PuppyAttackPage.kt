package com.stockbuddy

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.stockbuddy.UniversalDef.PuppyFrame
import com.stockbuddy.UniversalDef.TopBar


//class Stock : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            StockPage(navController)
//        }
//    }
//}

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("RestrictedApi")
//@Preview(name = "Stock") // NavController param needs to be commented to see preview
@Composable
fun PuppyAttackPage(navController : NavHostController) {
//    StockBuddyTheme {
    //val navController = rememberNavController()
    //val currentBackStack by navController.currentBackStackEntryAsState()
    //val currentDestination = currentBackStack?.destination
    //val currentScreen = stockBuddyTabRowScreens.find { it.route == currentDestination?.route } ?: FirstScreen


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
        TopBar(navController = navController, title = "PuppyAttack")

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LazyColumn {
                item { PuppyFrame(navController, R.drawable.img_rectangle20) }
                item { PuppyFrame(navController, R.drawable.img_rectangle21) }
                item { PuppyFrame(navController, R.drawable.img_rectangle22) }
                item { PuppyFrame(navController, R.drawable.img_rectangle23) }
            }
        }
    }
}











