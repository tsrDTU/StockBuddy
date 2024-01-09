package com.stockbuddy.util

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun searchBar(navController: NavHostController){
        var input by remember { mutableStateOf("") }
        var status by remember { mutableStateOf(false) }
        Scaffold{
            SearchBar(
                modifier = Modifier.fillMaxWidth(),
                query = input,
                onQueryChange = {
                    input = it
                },
                onSearch ={
                    status = false
                },
                active = status,
                onActiveChange ={
                    status = it
                },
                placeholder ={
                    Text(text = "Search")
                },
                leadingIcon ={
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                }
            )
            {

            }
        }
    }

