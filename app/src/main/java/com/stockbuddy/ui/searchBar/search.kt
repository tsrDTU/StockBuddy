package com.stockbuddy.ui.searchBar

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun search(){
    var input by remember { mutableStateOf("") }
    var status by remember { mutableStateOf(false) }
    Scaffold{
        SearchBar(query = input,
            onQueryChange = {
                input = it
            },
            onSearch ={
                status = false
            },
            active = status,
            onActiveChange ={
                status = it
            } )
        {

        }
    }
}