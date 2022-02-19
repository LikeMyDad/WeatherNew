package lmd.pet.weathernew.screens.start

sealed class StartState{
    object Empty: StartState()
    object Loading: StartState()
}
