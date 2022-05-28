package lmd.pet.weathernew

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import lmd.pet.weathernew.ui.screens.cities.CitiesScreen
import lmd.pet.weathernew.ui.screens.cities.models.CitiesViewModel
import lmd.pet.weathernew.ui.screens.main.MainScreen
import lmd.pet.weathernew.ui.screens.main.models.MainViewModel
import lmd.pet.weathernew.ui.screens.start.StartScreen
import lmd.pet.weathernew.ui.screens.start.models.StartViewModel
import lmd.pet.weathernew.utils.NavigationDest
import org.koin.androidx.compose.koinViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            Surface {
                NavHost(navController = navController, startDestination = NavigationDest.StartScreen.name) {
                    composable(NavigationDest.StartScreen.name) {
                        val startViewModel = koinViewModel<StartViewModel>()
                        StartScreen(navController = navController, viewModel = startViewModel)
                    }
                    composable(NavigationDest.CitiesScreen.name) {
                        val citiesViewModel = koinViewModel<CitiesViewModel>()
                        CitiesScreen(navController = navController, viewModel = citiesViewModel)
                    }
                    composable(NavigationDest.MainScreen.name) {
                        val mainViewModel = koinViewModel<MainViewModel>()
                        MainScreen(navController = navController, viewModel = mainViewModel)
                    }
                }
            }
        }
    }
}