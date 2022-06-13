package lmd.pet.weathernew.ui.screens.cities.models

import androidx.compose.runtime.Immutable
import lmd.pet.weathernew.core.base.UiEvent
import lmd.pet.weathernew.data.entity.dao.cities.CityModel

@Immutable
sealed class CitiesEvent : UiEvent {
    object EnterScreen : CitiesEvent()
    data class SearchCities(val query: String): CitiesEvent()
    data class LoadNextPageCities(val page: Int): CitiesEvent()
    data class DisplayCities(val cities: List<CityModel>): CitiesEvent()
    data class SelectCity(val id: Int): CitiesEvent()
    object Navigate : CitiesEvent()
}
