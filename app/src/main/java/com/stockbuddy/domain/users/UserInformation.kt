package com.stockbuddy.domain.users

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.BoxScopeInstance.align
//import androidx.compose.foundation.layout.ColumnScopeInstance.align
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
//import androidx.compose.foundation.layout.BoxScopeInstance.align
//import androidx.compose.foundation.layout.RowScopeInstance.align
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.stockbuddy.R
import com.stockbuddy.data.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.stockbuddy.UniversalDef.StockBox
import com.stockbuddy.UniversalDef.StockBoxSecond
import com.stockbuddy.UniversalDef.TopBar
import com.stockbuddy.domain.users.ShowUserInformation
import com.stockbuddy.domain.users.UserViewModel
import javax.inject.Singleton


@Singleton
var userIdFirestore : String = ""

var userFirstname : String = "Name"
var userLastname : String = "Namerson"

/**
 * Adding a user in Firestore.
 */
fun addUser (userId : String, first : String, last : String, email : String) {

   val user = hashMapOf(
        "UserId" to userId,
        "FirstName" to first,
        "LastName" to last,
       "Emailaddress" to email
)


    val db = Firebase.firestore
    db.collection("users")
        .add(user)
        .addOnSuccessListener {documentReference ->
          Log.d (TAG,  "DocumentSnapshot added with ID: $(documentReference.id)")
        }
        .addOnFailureListener { e ->
            Log.d(TAG, "Error adding document", e)
        }
}

    fun selectUserInFirestore(userId: String) {

        userIdFirestore = userId
  }


/**
*  Viewmodel for retrieving user data from Firestore
 * created by Torben Rasmussen With assistance from chatGPT
 */
class UserViewModel : ViewModel() {
    private var _actUser = MutableStateFlow<List<UserData>>(emptyList())
    var actUser: StateFlow<List<UserData>> = _actUser

    init {
        ReadUser(userIdFirestore)
    }

  @SuppressLint("SuspiciousIndentation")
  private fun ReadUser(userId: String){

      val db = Firebase.firestore


      val usr:UserData = UserData(
       emailaddress = "",
       firstName = "",
       lastName = "",
       userId = ""
      )


        db.collection("users")
            .whereEqualTo("UserId", userId)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        Log.d("StateFlow", document.id + " => " + document.data)

                        usr.userId = document.getString("UserId").toString()
                        usr.firstName = document.getString("FirstName").toString()
                        usr.lastName = document.getString("LastName").toString()
                        usr.emailaddress = document.getString("Emailaddress").toString()


                        val updatedList = _actUser.value.toMutableList().apply {
                            add(usr)
                        }
                        _actUser.value = updatedList


                    }
                } else {
                    Log.d("StateFlow", "Error getting documents: ", task.exception)
                }
            }

    }
}


@Composable

fun ShowUserInformation(viewModel: UserViewModel, navController : NavController) {

    val dataList by viewModel.actUser.collectAsState()


    LazyColumn {
        items(dataList) { dataList ->


            Box(
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.DefaultWidth))
                    .padding(top = 8.dp, bottom = 8.dp)
                    .height(146.dp)
                    .background(colorResource(id = R.color.regularBox))

                    .clickable {
                        navController.navigate("portfolioPage")
                    }



            ) {
                val fnvn : String = dataList.firstName.toString()
                val  lnvn : String = dataList.lastName.toString()

                Text(
                    text = "\n   User name: $fnvn $lnvn\n   Portfolio Preview",
                    color = Color.White // Set the text color
                )


            }

        }
    }
}




fun verificateUserId(navController: NavHostController) {
    val db = Firebase.firestore

    db.collection("users")
        .whereEqualTo("UserId", userIdFirestore)
        .get()
        .addOnSuccessListener { documents ->
            for (document in documents) {
                // UserId found, navigate to next screen
                navController.navigate("HomePage")
                return@addOnSuccessListener
            }
            navController.navigate("NewUser")
        }
        .addOnFailureListener { e ->
            // Handle failure
        }
}


fun getUserFirstAndLastName() {
    val db = Firebase.firestore

    db.collection("users")
        .whereEqualTo("UserId", userIdFirestore)
        .get()

        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                for (document in task.result) {
                    Log.d("StateFlow", document.id + " => " + document.data)


                    userFirstname = document.getString("FirstName").toString()
                    userLastname = document.getString("LastName").toString()




                }
            } else {
                Log.d("StateFlow", "Error getting documents: ", task.exception)
            }
        }
}

