package lmd.pet.weathernew.screens.cities.models

sealed class CitiesState{
    object Empty: CitiesState()
    object Loading: CitiesState()
}
