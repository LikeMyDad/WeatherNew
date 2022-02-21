package lmd.pet.weathernew.screens.cities

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun CitiesScreen(
    viewModel: CitiesViewModel
) {
    val viewState = viewModel.uiStateFlow.observeAsState()


}