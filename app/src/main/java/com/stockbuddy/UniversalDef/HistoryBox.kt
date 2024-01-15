package com.stockbuddy.UniversalDef

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.stockbuddy.R
import com.stockbuddy.domain.users.ShowStockHistory
import com.stockbuddy.domain.users.StockViewModel

@Composable
fun HistoryBox(navController: NavHostController, message: String) {
 //   TopBar(navController = navController, title = "History")

 //   ShowStockHistory( StockViewModel(),navController )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(94.dp)
            .padding(top = 4.dp, bottom = 4.dp)
    ) {
        // Content of the first Box
        Box(
            modifier = Modifier
                .width(370.dp)
                .height(120.dp)
                .background(colorResource(id = R.color.regularBox))
                .align(Alignment.TopCenter)
                .padding(8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            // Third Text (Fills the rest of the space)
            Text(
                text = message,
                color = Color.White, // Set the text color
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp)
                    .align(Alignment.TopStart)
                    ,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }




}