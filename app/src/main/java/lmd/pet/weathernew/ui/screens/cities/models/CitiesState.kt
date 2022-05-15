package lmd.pet.weathernew.ui.screens.cities.models

import androidx.compose.runtime.Immutable
import lmd.pet.weathernew.core.base.UiState
import lmd.pet.weathernew.data.entity.dao.cities.CityModel

@Immutable
sealed class CitiesState : UiState {
    object Empty : CitiesState()
    object Loading : CitiesState()
    data class DisplayCities(val items: List<CityModel>) : CitiesState()
    object Navigate : CitiesState()
}