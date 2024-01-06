package com.stockbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.stockbuddy.domain.users.MyViewModel
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

                    selectUserInFirestore("tsr")
                    ShowUserInformation(viewModel = MyViewModel())

                }
            }
        }

    }
/*
With assistance from ChatGPT

 */

    @Composable
    fun ShowUserInformation(viewModel: MyViewModel) {
        val dataList by viewModel.actUser.collectAsState()

        LazyColumn {
            items(dataList) { dataList ->
                // ListItemComposable
   //             Text(text = dataList.toString())
                Text(text = dataList.FirstName.toString())
                Text(text = dataList.LastName.toString())
            }
        }
    }

}



