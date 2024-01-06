package com.stockbuddy

import android.R
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.stockbuddy.domain.users.MyViewModel
import com.stockbuddy.domain.users.ReadUser
import com.stockbuddy.domain.users.getFirstName
import com.stockbuddy.domain.users.getLastName
import com.stockbuddy.domain.users.getNytTal

//import res.drawable.img_notification.xml



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

                    MyScreen(viewModel = MyViewModel())
                    Greeting("Android")
                }
            }
        }

    }
/*
From ChatGPT

 */

    @Composable
    fun MyScreen(viewModel: MyViewModel) {
        val dataList by viewModel.actUser.collectAsState()


        // Brug dataList til at bygge din komposable
        LazyColumn {
            items(dataList) { dataList ->
                // Din ListItemComposable f.eks.
                Text(text = dataList.toString())
            }
        }
    }







    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
    var n : Int = 1
        var str : String



        Text(
            text = "Hello $name!",
            modifier = modifier
        )



    }



    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        TestTheme {

            Greeting("Android")
        }
    }
}
/*
private fun <RowScope> RowScope.Text(println: Unit) {

}

 */
