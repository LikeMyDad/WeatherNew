package lmd.pet.weathernew.ui.screens.main

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import lmd.pet.weathernew.ui.composable.Loading
import lmd.pet.weathernew.ui.screens.main.models.MainState
import lmd.pet.weathernew.ui.screens.main.models.MainViewModel
import lmd.pet.weathernew.ui.screens.main.views.MainViewDisplay

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MainViewModel
) {
    val viewState by viewModel.state.collectAsState()

    when(val state = viewState) {
        is MainState.Loading -> Loading()
        is MainState.DisplayCityWeather -> {
            MainViewDisplay()
            Log.d("CityWeather", "${state.weather}")
        }
    }

}