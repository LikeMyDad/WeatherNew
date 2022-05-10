package lmd.pet.weathernew.screens.cities.models

import lmd.pet.weathernew.core.base.UiState
import lmd.pet.weathernew.data.entity.dao.cities.CityModel

sealed class CitiesState : UiState {
    object Empty : CitiesState()
    object Loading : CitiesState()
    data class SearchCities(val query: String) : CitiesState()
    data class DisplayCities(val items: List<CityModel>) : CitiesState()
}