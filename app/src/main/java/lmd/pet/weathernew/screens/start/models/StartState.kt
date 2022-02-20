package lmd.pet.weathernew.screens.start.models

sealed class StartState{
    object Empty: StartState()
    object Loading: StartState()
}
