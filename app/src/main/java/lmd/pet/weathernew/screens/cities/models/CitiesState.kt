package lmd.pet.weathernew.screens.cities.models

import lmd.pet.weathernew.data.entity.dao.cities.CityModel

sealed class CitiesState{
    object Empty: CitiesState()
    object Loading: CitiesState()
    data class DisplayCities(val items: List<CityModel>): CitiesState()
}
