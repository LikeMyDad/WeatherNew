package lmd.pet.weathernew

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import dagger.hilt.android.AndroidEntryPoint
import lmd.pet.weathernew.screens.cities.CitiesScreen
import lmd.pet.weathernew.screens.cities.models.CitiesViewModel
import lmd.pet.weathernew.screens.main.MainScreen
import lmd.pet.weathernew.screens.main.models.MainViewModel
import lmd.pet.weathernew.screens.start.StartScreen
import lmd.pet.weathernew.screens.start.models.StartViewModel
import lmd.pet.weathernew.utils.NavigationDest

@ExperimentalPermissionsApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            val locationPermission = rememberMultiplePermissionsState(
                listOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                )
            )

            Surface {
                NavHost(navController = navController, startDestination = "startScreen") {
                    composable(NavigationDest.StartScreen.screen) {
                        val startViewModel = hiltViewModel<StartViewModel>()
                        StartScreen(navController = navController, viewModel = startViewModel, multiplePermissionsState = locationPermission)
                    }
                    composable(NavigationDest.CitiesScreen.screen) {
                        val citiesViewModel = hiltViewModel<CitiesViewModel>()
                        CitiesScreen(navController = navController, viewModel = citiesViewModel)
                    }
                    composable(NavigationDest.MainScreen.screen) {
                        val mainViewModel = hiltViewModel<MainViewModel>()
                        MainScreen(navController = navController, viewModel = mainViewModel)
                    }
                }
            }
        }
    }
}