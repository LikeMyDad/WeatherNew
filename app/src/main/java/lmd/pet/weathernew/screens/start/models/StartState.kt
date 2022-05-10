package lmd.pet.weathernew.screens.start.models

import lmd.pet.weathernew.core.base.UiState
import lmd.pet.weathernew.utils.NavigationDest

data class StartState(
    val navigationDest: NavigationDest
): UiState {
    companion object {
        fun initial() = StartState(NavigationDest.NO_DEST)
    }
}