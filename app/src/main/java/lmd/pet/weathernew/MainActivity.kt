package lmd.pet.weathernew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import dagger.hilt.android.AndroidEntryPoint
import lmd.pet.weathernew.ui.screens.cities.CitiesScreen
import lmd.pet.weathernew.ui.screens.cities.models.CitiesViewModel
import lmd.pet.weathernew.ui.screens.main.MainScreen
import lmd.pet.weathernew.ui.screens.main.models.MainViewModel
import lmd.pet.weathernew.ui.screens.start.StartScreen
import lmd.pet.weathernew.ui.screens.start.models.StartViewModel
import lmd.pet.weathernew.utils.NavigationDest

@ExperimentalPermissionsApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            Surface {
                NavHost(navController = navController, startDestination = NavigationDest.StartScreen.name) {
                    composable(NavigationDest.StartScreen.name) {
                        val startViewModel = hiltViewModel<StartViewModel>()
                        StartScreen(navController = navController, viewModel = startViewModel)
                    }
                    composable(NavigationDest.CitiesScreen.name) {
                        val citiesViewModel = hiltViewModel<CitiesViewModel>()
                        CitiesScreen(navController = navController, viewModel = citiesViewModel)
                    }
                    composable(NavigationDest.MainScreen.name) {
                        val mainViewModel = hiltViewModel<MainViewModel>()
                        MainScreen(navController = navController, viewModel = mainViewModel)
                    }
                }
            }
        }
    }
}