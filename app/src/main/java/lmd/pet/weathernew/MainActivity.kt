package lmd.pet.weathernew

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import lmd.pet.weathernew.ui.screens.cities.CitiesScreen
import lmd.pet.weathernew.ui.screens.cities.models.CitiesViewModel
import lmd.pet.weathernew.ui.screens.general.views.MainMenuItems
import lmd.pet.weathernew.ui.screens.main.MainScreen
import lmd.pet.weathernew.ui.screens.main.models.MainViewModel
import lmd.pet.weathernew.ui.screens.settings.SettingScreen
import lmd.pet.weathernew.ui.screens.start.StartScreen
import lmd.pet.weathernew.ui.screens.start.models.StartViewModel
import lmd.pet.weathernew.utils.NavigationDest
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            var titleScreen by remember { mutableStateOf("") }

            Log.d("AS", "updated")

            MaterialTheme {
                Scaffold(topBar = {
                    MainMenuItems(title = titleScreen, navController = navController)
                }) {
                    NavHost(
                        navController = navController,
                        startDestination = NavigationDest.StartScreen.name
                    ) {
                        composable(NavigationDest.StartScreen.name) {
                            val startViewModel = koinViewModel<StartViewModel>()
                            titleScreen = "StartScreen"
                            StartScreen(navController = navController, viewModel = startViewModel)
                        }
                        composable(NavigationDest.CitiesScreen.name) {
                            val citiesViewModel = koinViewModel<CitiesViewModel>()
                            titleScreen = "CitiesScreen"
                            CitiesScreen(navController = navController, viewModel = citiesViewModel)
                        }
                        composable(NavigationDest.MainScreen.name) {
                            titleScreen = "WeatherScreen"
                            val mainViewModel = koinViewModel<MainViewModel>()
                            MainScreen(navController = navController, viewModel = mainViewModel)
                        }
                        composable(NavigationDest.SettingScreen.name) {
                            titleScreen = "SettingsScreen"
                            SettingScreen() {
                                applyOverrideConfiguration(it)
                            }
                        }
                    }
                }

            }
        }
    }

}