package com.stockbuddy.UniversalDef

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.stockbuddy.R

@Composable
fun NotificationsBox(navController: NavHostController, title : String, time : String, description : String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(104.dp)
            .padding(top = 4.dp, bottom = 4.dp)
    ) {
        // Content of the first Box
        Box(
            modifier = Modifier
                .width(dimensionResource(id = R.dimen.DefaultWidth))
                .height(160.dp)
                .background(colorResource(id = R.color.regularBox))
                .align(Alignment.TopCenter)
                .padding(4.dp),
            contentAlignment = Alignment.TopStart
        ) {
            // Use a Row for the first and second Text fields
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // First Text (Top Left)
                Text(
                    text = title,
                    color = Color.White, // Set the text color
                    fontWeight = FontWeight.Bold // Set the text to bold
                )

                // Second Text (Top Right)
                Text(
                    text = time,
                    color = Color.White, // Set the text color
                    fontWeight = FontWeight.Bold // Set the text to bold
                )
            }

            // Third Text (Fills the rest of the space)
            Text(
                text = description,
                color = Color.White, // Set the text color
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 21.dp)
                    .align(Alignment.TopStart),
                fontSize = 14.sp
            )
        }
    }
}