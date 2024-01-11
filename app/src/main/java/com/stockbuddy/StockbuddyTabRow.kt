package com.stockbuddy

//import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.stockbuddy.UniversalDef.TopBar


@Composable
fun StockBuddyTabRow(navController : NavHostController
//    allScreens : List<StockBuddyDestination>,
//    onTabSelected: (StockBuddyDestination) -> Unit,
//    currentScreen: StockBuddyDestination
) {
    Column {
        TopBar(navController = navController, title = "Account")


        Surface(
            Modifier
                .height(TabHeight)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(Color(R.color.purple_200))
                        .clip(RoundedCornerShape(8.dp))
                        .align(Alignment.Center),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .height(10.dp)
                            .width(36.dp)
                            .padding(start = 16.dp)
                            .background(Color.Blue)

                    )
                    Spacer(modifier = Modifier.width(200.dp))

                    Box(
                        modifier = Modifier
                            .height(10.dp)
                            .width(20.dp)
                            .background(Color.Blue)

                    )
                    Box(
                        modifier = Modifier
                            .height(10.dp)
                            .width(20.dp)
                            .background(Color.Blue)

                    )
                    Box(
                        modifier = Modifier
                            .height(10.dp)
                            .width(20.dp)
                            .background(Color.Blue)
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                }
            }
        }
    }
}
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
////    val tabTintColor by animateColorAsState(
////        targetValue = if (selected) color else color.copy(alpha = InactiveTabOpacity),
////        animationSpec = animSpec
////    )
////    Row(
////        modifier = Modifier
////            .padding(16.dp)
////            .animateContentSize()
////            .height(TabHeight)
////            .selectable(
////                selected = selected,
////                onClick = onSelected,
////                role = Role.Tab,
////                interactionSource = remember {
////                    MutableInteractionSource()
////                },
////                indication = rememberRipple(
////                    bounded = false,
////                    radius = Dp.Unspecified,
////                    color = Color.Unspecified
////                )
////            )
////            .clearAndSetSemantics { contentDescription = text }
////    ) {
////        Icon(imageVector = icon, contentDescription = text, tint = tabTintColor)
////        if (selected) {
////            Spacer(Modifier.width(12.dp))
////            Text(text.uppercase(Locale.getDefault()), color = tabTintColor)
////        }
////
////
////    }
//}
//
//
private val TabHeight = 56.dp
//private const val InactiveTabOpacity = 0.60f
//
//private const val TabFadeInAnimationDuration = 150
//private const val TabFadeInAnimationDelay = 100
//private const val TabFadeOutAnimationDuration = 100
