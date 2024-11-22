package com.example.raionacademylvl3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.raionacademylvl3.ui.theme.RaionAcademyLVL3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RaionAcademyLVL3Theme {
                val navController = rememberNavController()
                val sharedViewModel: SharedViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

                NavHost(
                    navController = navController,
                    startDestination = "app_screen"
                ) {
                    composable("app_screen") {
                        AppScreen(navController, sharedViewModel)
                    }
                    composable("detail_screen/{productName}") { backStackEntry ->
                        val productName = backStackEntry.arguments?.getString("productName")
                        DetailScreen(productName = productName, sharedViewModel = sharedViewModel)
                    }
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        RaionAcademyLVL3Theme {
            Greeting("Android")
        }
    }
}