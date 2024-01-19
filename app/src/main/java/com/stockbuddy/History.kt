package com.stockbuddy

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.stockbuddy.UniversalDef.TopBar
import com.stockbuddy.domain.users.ShowInvestmentResult
import com.stockbuddy.domain.users.ShowStockHistory
import com.stockbuddy.domain.users.StockViewModel
import com.stockbuddy.domain.users.setHitorySummaryVarsToZero


@SuppressLint("RestrictedApi")
//@Preview(name = "History")
@Composable
fun HistoryPage(navController : NavHostController) {


    Column {
        TopBar(navController = navController, title = "History")

       // setHitorySummaryVarsToZero()
        ShowStockHistory(StockViewModel(),navController )
   //     ShowInvestmentResult(navController)

    }
}








