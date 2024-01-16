package com.stockbuddy.UniversalDef

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.stockbuddy.R

@Composable
fun PuppyFrame(navController: NavHostController, pictureID : Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(top = 4.dp, bottom = 4.dp)
    ) {
        // Content of the first Box
        Box(
            modifier = Modifier
                .width(dimensionResource(id = R.dimen.DefaultWidth))
                .background(colorResource(id = R.color.regularBox))
                .align(Alignment.Center)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = pictureID),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color.Gray, // Placeholder background color
                        shape = RoundedCornerShape(64.dp)
                    ),
                contentScale = ContentScale.Crop
            )
        }
    }
}