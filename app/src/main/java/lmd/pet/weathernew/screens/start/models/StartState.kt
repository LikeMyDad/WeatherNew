package lmd.pet.weathernew.screens.start.models

sealed class StartState{
    object Empty: StartState()
    object Display: StartState()
}
