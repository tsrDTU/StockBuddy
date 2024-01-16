package com.stockbuddy

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

                //Added
                item { PuppyFrame(navController, R.drawable.img_rectangle24) }
                item { PuppyFrame(navController, R.drawable.img_rectangle25) }
                item { PuppyFrame(navController, R.drawable.img_rectangle26) }
                item { PuppyFrame(navController, R.drawable.img_rectangle27) }
                item { PuppyFrame(navController, R.drawable.img_rectangle28) }
                item { PuppyFrame(navController, R.drawable.img_rectangle29) }
                item { PuppyFrame(navController, R.drawable.img_rectangle30) }
                item { PuppyFrame(navController, R.drawable.img_rectangle31) }
                item { PuppyFrame(navController, R.drawable.img_rectangle32) }
            }
        }
    }
}











