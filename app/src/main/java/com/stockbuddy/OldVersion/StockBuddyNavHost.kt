//package com.stockbuddy.OldVersion
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.navigation.NavGraph.Companion.findStartDestination
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//
//
//@Composable
//fun StockBuddyNavHost(
//    navController: NavHostController,
//    modifier: Modifier = Modifier
//) {
//    NavHost(
//        navController = navController,
//        startDestination = FirstScreen.route,
//        modifier = modifier
//    ) {
//        composable(route = FirstScreen.route) {
//            /*
//            OverviewScreen(
//                onClickSeeAllAccounts = {
//                    navController.navigateSingleTopTo(Accounts.route)
//                },
//                onClickSeeAllBills = {
//                    navController.navigateSingleTopTo(Bills.route)
//                },
//                onAccountClick = { accountType ->
//                    navController.navigateToSingleAccount(accountType)
//                }
//            )
//
//
//        }
//        composable(route = Accounts.route) {
//            AccountsScreen(
//                onAccountClick = { accountType ->
//                    navController.navigateToSingleAccount(accountType)
//                }
//            )
//        }
//
//        composable(route = Bills.route) {
//            BillsScreen()
//        }
//        composable(
//            route = SingleAccount.routeWithArgs,
//            arguments = SingleAccount.arguments,
//            deepLinks = SingleAccount.deepLinks
//        ) { navBackStackEntry ->
//            val accountType =
//                navBackStackEntry.arguments?.getString(SingleAccount.accountTypeArg)
//            SingleAccountScreen(accountType)
//        }
//
//         */
//        }
//        composable("stockPage")  { StockPage(navController) }
//    }
//}
//    fun NavHostController.navigateSingleTopTo(route: String) =
//        this.navigate(route) {
//            // Pop up to the start destination of the graph to
//            // avoid building up a large stack of destinations
//            // on the back stack as users select items
//            popUpTo(
//                this@navigateSingleTopTo.graph.findStartDestination().id
//            ) {
//                saveState = true
//            }
//            // Avoid multiple copies of the same destination when
//            // reselecting the same item
//            launchSingleTop = true
//            // Restore state when reselecting a previously selected item
//            restoreState = true
//        }
//
//private fun NavHostController.navigateToSingleAccount(accountType: String) {
//        this.navigateSingleTopTo("${SingleAccount.route}/$accountType")
//
//}