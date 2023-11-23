package com.stockbuddy.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.compose.material3.Button
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.material3.Text

class HomeViewModel : ViewModel() {
  //  private var _binding: FragmentFirstBinding? = null
 //   private val binding get() = _binding!!
 //   _binding = FragmentFirstBinding.inflate(inflater, container, false)

 //   _binding
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"

    }
    val text: LiveData<String> = _text

}


