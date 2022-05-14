package lmd.pet.weathernew.screens.cities.models

import androidx.compose.runtime.Immutable
import lmd.pet.weathernew.core.base.UiEvent
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.utils.NavigationDest

@Immutable
sealed class CitiesEvent : UiEvent {
    object EnterScreen : CitiesEvent()
    data class SearchCities(val query: String): CitiesEvent()
    data class DisplayCities(val cities: List<CityModel>): CitiesEvent()
    data class SelectCity(val id: Int): CitiesEvent()
    object Navigate : CitiesEvent()
}
