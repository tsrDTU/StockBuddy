package com.stockbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.stockbuddy.domain.users.UserViewModel
import com.stockbuddy.domain.users.ShowUserInformation
import com.stockbuddy.domain.users.addUser
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

               //     addUser("bd", "Stock", "Buddy", "stock.buddy@mail.dummy")
                    selectUserInFirestore("bd")
                    ShowUserInformation(viewModel = UserViewModel())

                }
            }
        }

    }


}



