package lmd.pet.weathernew.ui.screens.cities

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.ui.screens.cities.models.CitiesState
import lmd.pet.weathernew.ui.screens.cities.models.CitiesViewModel
import lmd.pet.weathernew.ui.composable.Loading
import lmd.pet.weathernew.ui.screens.cities.views.CitiesViewDisplay
import lmd.pet.weathernew.utils.NavigationDest

@Composable
fun CitiesScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CitiesViewModel
) {
    val viewState by viewModel.state.collectAsState()
    val messageStates = remember { mutableStateOf("") }

    val searchQuery: (String) -> Unit = { query ->
        messageStates.value = query
        viewModel.searchCitiesByQuery(query)
    }

    val selectCity: (CityModel) -> Unit = { city ->
        viewModel.selectCity(city.id)
    }

    when(val state = viewState) {
        is CitiesState.Loading -> Loading()
        is CitiesState.DisplayCities -> CitiesViewDisplay(
            modifier = modifier,
            viewState = state,
            onValueChange = searchQuery,
            messageStates = messageStates,
            selectedCity = selectCity
        )
        is CitiesState.Navigate -> {
            LaunchedEffect(key1 = Unit) {
                navController.navigate(NavigationDest.MainScreen.name)
            }
        }
        else -> throw Exception("Cant handle CitiesState")
    }
}