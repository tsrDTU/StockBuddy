package com.stockbuddy



import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.ImeAction
import androidx.navigation.NavHostController
import com.stockbuddy.domain.users.addUser
import com.stockbuddy.domain.users.userIdFirestore


// With assistance from from ChatGPT Torben created this



@Composable
fun NewUser( navController : NavHostController) {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var emailAddress by remember { mutableStateOf("") }

    LazyColumn {
        item {

            Text(text = "User ID : $userIdFirestore")

        }

    item {
        TextField(
            value = firstName,
            onValueChange = {
                firstName = it
            },
            label = { Text("Enter first name: ") },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )
    }

        item {
            TextField(
                value = lastName,
                onValueChange = {
                    lastName = it
                },
                label = { Text("Enter last name: ") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                )
            )
        }
        item {
            TextField(
                value = emailAddress,
                onValueChange = {
                    emailAddress = it

                },
                label = { Text("Enter E-mail address: ") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {

                    if (userIdFirestore != "" && firstName != "" && lastName != "" && emailAddress != "")
                    {
                        addUser(userIdFirestore, firstName, lastName, emailAddress)
                        navController.navigate("HomePage")
                    }
                })
            )
        }


  }

}

