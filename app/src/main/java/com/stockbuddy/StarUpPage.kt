package com.stockbuddy

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.stockbuddy.domain.users.ShowUserExsistInformation
import com.stockbuddy.domain.users.UserExistViewModel
import com.stockbuddy.domain.users.selectUserInFirestore

@Composable
fun BeginApp(navController : NavHostController){

    StartUpPage(navController)

}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@SuppressLint("RestrictedApi", "UnusedMaterial3ScaffoldPaddingParameter")
//@Preview
@Composable
fun StartUpPage(navController : NavHostController) {



    Column {
      //  TopBar(navController = navController, title = "Search")


        LazyColumn {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                ) {
                    var input by remember { mutableStateOf("") }
                    var status by remember { mutableStateOf(false) }
                    var items = remember {
                        mutableListOf(
                            "userId"

                            //Tilføj stocks her gennem API
                        )
                    }


                    Scaffold {
                        SearchBar(
                            modifier = Modifier.fillMaxWidth(),
                            query = input,
                            onQueryChange = {
                                input = it
                            },
                            onSearch = {
                              var  userEks = true

                           //     selectUserInFirestore(input, modifier = Modifier)
                                selectUserInFirestore(input)


                        //        ShowUserExsistInformation(UserExistViewModel())


                                    if (userEks) {
                                        navController.navigate("HomePage")
                                    }

                            },
                            active = status,
                            onActiveChange = {
                                status = it
                            },
                            placeholder = {
                                Text(text = "Enter user ID")
                            }


                            )

                        {


                            items.forEach {
                                Row(modifier = Modifier
                                    .padding(20.dp)
                                    .clickable { navController.navigate(it) }
                                )
                                {
                                    Icon(
                                        modifier = Modifier
                                            .padding(end = 14.dp),
                                        imageVector = Icons.Default.History,
                                        contentDescription = "history"
                                    )
                                    Text(text = it)
                                }
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(46.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 0.dp
                            )
                        )
                        .background(colorResource(id = R.color.regularBox))
                        .padding(top = 16.dp)
                        .alpha(1f),
                    horizontalArrangement = Arrangement.SpaceBetween // Aligns items at the start and end of the row
                ) {

                }
            }


        }
    }

}

