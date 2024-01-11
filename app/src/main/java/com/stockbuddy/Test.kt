package com.stockbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.stockbuddy.domain.users.ShowTotalStockValue
import com.stockbuddy.domain.users.StockTotalValueViewModel
import com.stockbuddy.domain.users.selectUserInFirestore


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
          //          purchaseStock("bd", "IBM", 3447,315.0,12.0, "2024-01-06" )
          //          purchaseStock("bd", "HP", 2475,733.0,15.0, "2024-01-08" )
          //          purchaseStock("bd", "MicroSoft", 987,876.0,18.0, "2024-01-10" )
          //          purchaseStock("bd", "Google", 667,1340.0,18.0, "2024-01-11" )
          //          sellStock ("bd", "IBM", 547.0, 18.0, "2024-01-10")
         //           sellStock ("bd", "HP", 2814.0, 18.0, "2024-01-11")
                    selectUserInFirestore("bd")
          //          selectStockInFirestore("IBM")
           //         ShowUserInformation(viewModel = UserViewModel())
            //        ShowStockInformation(viewModel = StockViewModel())
                    ShowTotalStockValue(viewModel = StockTotalValueViewModel())

                }
            }
        }

    }


}



