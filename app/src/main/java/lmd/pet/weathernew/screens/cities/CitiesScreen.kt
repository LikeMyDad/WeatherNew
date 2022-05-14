package lmd.pet.weathernew.screens.cities

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.screens.cities.models.CitiesState
import lmd.pet.weathernew.screens.cities.models.CitiesViewModel
import lmd.pet.weathernew.screens.cities.views.CitiesLoading
import lmd.pet.weathernew.screens.cities.views.CitiesViewDisplay
import lmd.pet.weathernew.utils.NavigationDest
import java.lang.Exception

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
        is CitiesState.Loading -> CitiesLoading()
        is CitiesState.DisplayCities -> CitiesViewDisplay(
            modifier = modifier,
            viewState = state,
            onValueChange = searchQuery,
            messageStates = messageStates,
            selectedCity = selectCity
        )
        is CitiesState.Navigate -> {
            navController.navigate(NavigationDest.MainScreen.name)
        }
        else -> throw Exception("Cant handle CitiesState")
    }
}