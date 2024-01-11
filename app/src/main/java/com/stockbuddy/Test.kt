package com.stockbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.stockbuddy.domain.users.ShowStockInformation
import com.stockbuddy.domain.users.ShowTotalStockValue
import com.stockbuddy.domain.users.UserViewModel
import com.stockbuddy.domain.users.StockViewModel
import com.stockbuddy.domain.users.ShowUserInformation
import com.stockbuddy.domain.users.StockTotalVavueViewModel
import com.stockbuddy.domain.users.addStock
import com.stockbuddy.domain.users.addUser
import com.stockbuddy.domain.users.selectStockInFirestore
import com.stockbuddy.domain.users.selectUserInFirestore
import com.stockbuddy.domain.users.sellStock


class Test: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                //    addUser("bd", "Stock", "Buddy", "stock.buddy@mail.dummy")
               //     addUser("tt", "Tin", "Tin", "tin.tin@mail.belg")
              //      addUser("kh", "Kaptajn", "Haddock", "kaptajn.haddock@mail.belg")
               //     addUser("ll", "Lucky", "Luke", "lucky.luke@mail.detvildevesten")
          //          addStock("bd", "IBM", 3447,315.0,12.0, "2024-01-06" )
          //          addStock("bd", "HP", 2475,733.0,15.0, "2024-01-08" )
          //          addStock("bd", "MicroSoft", 987,876.0,18.0, "2024-01-10" )
          //          sellStock ("bd", "IBM", 547.0, 18.0, "2024-01-10")
                    selectUserInFirestore("bd")
          //          selectStockInFirestore("IBM")
           //         ShowUserInformation(viewModel = UserViewModel())
           //         ShowStockInformation(viewModel = StockViewModel())
                    ShowTotalStockValue(viewModel = StockTotalVavueViewModel())

                }
            }
        }

    }


}



