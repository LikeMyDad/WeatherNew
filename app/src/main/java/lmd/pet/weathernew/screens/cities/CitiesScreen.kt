package lmd.pet.weathernew.screens.cities

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import lmd.pet.weathernew.screens.cities.models.CitiesEvent
import lmd.pet.weathernew.screens.cities.models.CitiesState
import lmd.pet.weathernew.screens.cities.models.CitiesViewModel
import lmd.pet.weathernew.screens.cities.views.CitiesLoading
import lmd.pet.weathernew.screens.cities.views.CitiesViewDisplay

@Composable
fun CitiesScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CitiesViewModel
) {
    val viewState by viewModel.stateLiveData.collectAsState()

    when (val state = viewState) {
        is CitiesState.Loading -> CitiesLoading()
        is CitiesState.DisplayCities -> {
            CitiesViewDisplay(
                modifier = modifier,
                navController = navController,
                viewState = state
            )
        }
    }

    LaunchedEffect(key1 = viewState) {
        viewModel.obtainEvent(event = CitiesEvent.EnterScreen)
    }
}