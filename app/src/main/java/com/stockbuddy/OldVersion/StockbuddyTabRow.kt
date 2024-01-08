//package com.stockbuddy.OldVersion
//
//import androidx.compose.animation.animateColorAsState
//import androidx.compose.animation.animateContentSize
//import androidx.compose.animation.core.LinearEasing
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.background
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.selection.selectable
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.ripple.rememberRipple
//import androidx.compose.material3.Icon
////import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.semantics.Role
//import androidx.compose.ui.semantics.clearAndSetSemantics
//import androidx.compose.ui.semantics.contentDescription
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import java.util.Locale
//import androidx.compose.material.MaterialTheme
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.draw.clip
//import com.stockbuddy.R
//
//
//@Composable
//fun StockBuddyTabRow(
//    allScreens : List<StockBuddyDestination>,
//    onTabSelected: (StockBuddyDestination) -> Unit,
//    currentScreen: StockBuddyDestination
//) {
//    Surface(
//        Modifier
//            .height(TabHeight)
//            .fillMaxWidth()
//    ){
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.Transparent)
//
//        ){
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight()
//                    .background(Color(R.color.stockBackground))
//                    .clip(RoundedCornerShape(8.dp))
//                    .align(Alignment.Center),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//
//                Box(
//                    modifier = Modifier
//                        .height(10.dp)
//                        .width(36.dp)
//                        .padding(start = 16.dp)
//                        .background(Color.Blue)
//
//                )
//                Spacer(modifier = Modifier.width(200.dp))
//
//                Box(
//                    modifier = Modifier
//                        .height(10.dp)
//                        .width(20.dp)
//                        .background(Color.Blue)
//
//                )
//                Box(
//                    modifier = Modifier
//                        .height(10.dp)
//                        .width(20.dp)
//                        .background(Color.Blue)
//
//                )
//                Box(
//                    modifier = Modifier
//                        .height(10.dp)
//                        .width(20.dp)
//                        .background(Color.Blue)
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//
//            }
//        }
//    }
//}
//
//@Composable
//private fun StockBuddyTab(
//    text: String,
//    icon: ImageVector,
//    onSelected: () -> Unit,
//    selected: Boolean
//) {
//    val color = MaterialTheme.colors.onSurface
//    val durationMillis = if (selected) TabFadeInAnimationDuration else TabFadeOutAnimationDuration
//    val animSpec = remember {
//        tween<Color>(
//            durationMillis = durationMillis,
//            easing = LinearEasing,
//            delayMillis = TabFadeInAnimationDelay
//        )
//    }
//
//    val tabTintColor by animateColorAsState(
//        targetValue = if (selected) color else color.copy(alpha = InactiveTabOpacity),
//        animationSpec = animSpec
//    )
//    Row(
//        modifier = Modifier
//            .padding(16.dp)
//            .animateContentSize()
//            .height(TabHeight)
//            .selectable(
//                selected = selected,
//                onClick = onSelected,
//                role = Role.Tab,
//                interactionSource = remember {
//                    MutableInteractionSource()
//                },
//                indication = rememberRipple(
//                    bounded = false,
//                    radius = Dp.Unspecified,
//                    color = Color.Unspecified
//                )
//            )
//            .clearAndSetSemantics { contentDescription = text }
//    ) {
//        Icon(imageVector = icon, contentDescription = text, tint = tabTintColor)
//        if (selected) {
//            Spacer(Modifier.width(12.dp))
//            Text(text.uppercase(Locale.getDefault()), color = tabTintColor)
//        }
//
//
//    }
//}
//
//
//private val TabHeight = 56.dp
//private const val InactiveTabOpacity = 0.60f
//
//private const val TabFadeInAnimationDuration = 150
//private const val TabFadeInAnimationDelay = 100
//private const val TabFadeOutAnimationDuration = 100
