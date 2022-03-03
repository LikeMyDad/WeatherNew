package lmd.pet.weathernew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import lmd.pet.weathernew.screens.compose.ComposeScreen
import lmd.pet.weathernew.screens.start.StartScreen
import lmd.pet.weathernew.screens.start.models.StartViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            Surface {
                NavHost(navController = navController, startDestination = "startScreen") {
                    composable("startScreen") {
                        val startViewModel = hiltViewModel<StartViewModel>()
                        StartScreen(navController = navController, viewModel = startViewModel)
                    }
                }
            }
        }
    }
}