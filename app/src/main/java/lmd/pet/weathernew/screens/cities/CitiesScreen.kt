package lmd.pet.weathernew.screens.cities

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
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
    val viewState = viewModel.stateLiveData.observeAsState()

    Log.d("CitiesScreen", "Start")

    when (val state = viewState.value) {
        is CitiesState.Loading -> CitiesLoading()
        is CitiesState.Display -> {
            CitiesViewDisplay(
                modifier = modifier,
                navController = navController,
                viewState = state
            )
        }
    }

    LaunchedEffect(key1 = viewState, block = {
        viewModel.obtainEvent(event = CitiesEvent.EnterScreen)
    })
}