package lmd.pet.weathernew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import lmd.pet.weathernew.screens.cities.CitiesScreen
import lmd.pet.weathernew.screens.cities.models.CitiesViewModel
import lmd.pet.weathernew.screens.start.StartScreen
import lmd.pet.weathernew.screens.start.models.StartViewModel
import lmd.pet.weathernew.utils.NavHostByRoute
import lmd.pet.weathernew.utils.NavigationDest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            Surface {
                NavHostByRoute(
                    navController = navController,
                    startDestination = NavigationDest.StartScreen
                ) { builder ->
                    with(builder) {
                        composable(NavigationDest.StartScreen.dest) {
                            val startViewModel = hiltViewModel<StartViewModel>()
                            StartScreen(navController = navController, viewModel = startViewModel)
                        }
                        composable(NavigationDest.CitiesScreen.dest) {
                            val citiesViewModel = hiltViewModel<CitiesViewModel>()
                            CitiesScreen(navController = navController, viewModel = citiesViewModel)
                        }
                        composable(NavigationDest.MainScreen.dest) {

                        }
                    }
                }
//                NavHost(navController = navController, startDestination = "startScreen") {
//                    composable("startScreen") {
//                        val startViewModel = hiltViewModel<StartViewModel>()
//                        StartScreen(navController = navController, viewModel = startViewModel)
//                    }
//                }
            }
        }
    }
}