package lmd.pet.weathernew.screens.cities.models

sealed class CitiesEvent {
    object EnterScreen : CitiesEvent()
    data class SearchCity(val query: String): CitiesEvent()
}
