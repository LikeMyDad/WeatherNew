package lmd.pet.weathernew.screens.start.models

import lmd.pet.weathernew.utils.NavigationDest

sealed class StartEvent {
    object EnterScreen : StartEvent()
    object Permission : StartEvent()
    data class Navigation(val dest: NavigationDest) : StartEvent()
}
