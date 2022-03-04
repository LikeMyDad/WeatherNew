package lmd.pet.weathernew.screens.start.models

sealed class StartEvent {
    object EnterScreen : StartEvent()
    object Permission : StartEvent()
}
