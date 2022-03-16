package lmd.pet.weathernew.screens.start.models

import lmd.pet.weathernew.utils.NavigationDest

sealed class StartState{
    object Empty: StartState()
    object Display: StartState()
    object Permission: StartState()
    data class Navigate(val dest: NavigationDest): StartState()
}
