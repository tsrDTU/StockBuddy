//package com.stockbuddy.OldVersion
//
//import android.os.Bundle
//import android.view.Menu
//import androidx.activity.compose.setContent
//import androidx.navigation.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.navigateUp
//import androidx.appcompat.app.AppCompatActivity
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.ui.Modifier
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.stockbuddy.R
//import com.stockbuddy.databinding.ActivityMainBinding
//import com.stockbuddy.ui.theme.StockBuddyTheme
//import dagger.hilt.android.AndroidEntryPoint
//
//@AndroidEntryPoint
//class MainActivity : AppCompatActivity() {
////cm1
//    private lateinit var appBarConfiguration: AppBarConfiguration
//    private lateinit var binding: ActivityMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            StockBuddyTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    // Set up the navigation controller
//                    val navController = rememberNavController()
//
//                    // Set up the navigation host
//                    NavHost(
//                        navController = navController,
//                        startDestination = "home"
//                    ) {
//                        composable("home") { MainPage(navController) }
//                        composable("stockPage") { StockPage(navController) }
//                    }
//                }
//            }
//        }
//
//
//
//    //
////        binding = ActivityMainBinding.inflate(layoutInflater)
////        setContentView(binding.root)
////
////        setSupportActionBar(binding.appBarMain.toolbar)
////
////        binding.appBarMain.fab.setOnClickListener { view ->
////            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                .setAction("Action", null).show()
////        }
////
////
////
////        val drawerLayout: DrawerLayout = binding.drawerLayout
////        val navView: NavigationView = binding.navView
////        val navController = findNavController(R.id.nav_host_fragment_content_main)
////        // Passing each menu ID as a set of Ids because each
////        // menu should be considered as top level destinations.
////        appBarConfiguration = AppBarConfiguration(
////            setOf(
////                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
////            ), drawerLayout
////        )
////        setupActionBarWithNavController(navController, appBarConfiguration)
////        navView.setupWithNavController(navController)
//    }
//
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.main, menu)
//
//        return true
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }
//}
//
///*
//@Composable
//fun LogButton() {
//    val viewModel: LoggingViewModel = hiltViewModel()
//
//    Column (modifier= Modifier.fillMaxSize(),
//        verticalArrangement =  Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Button(onClick = { viewModel.onLogbuttonClick () }) {
//            Text(text="Log!")
//        }
//    }
//}
//
//
// */