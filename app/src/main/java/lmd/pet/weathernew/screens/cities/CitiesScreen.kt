package lmd.pet.weathernew.screens.cities

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
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
    val viewState by viewModel.state.collectAsState()

    val callbackTest: (query: String) -> Unit = { query ->
        Log.d("CheckCities", query)
    }

    when(val state = viewState) {
        is CitiesState.Loading -> CitiesLoading()
        is CitiesState.DisplayCities -> CitiesViewDisplay(
            modifier = modifier,
            viewState = state,
            onValueChange = callbackTest
        )
    }
}