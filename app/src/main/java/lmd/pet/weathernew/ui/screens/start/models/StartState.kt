package lmd.pet.weathernew.ui.screens.start.models

import androidx.compose.runtime.Immutable
import lmd.pet.weathernew.core.base.UiState
import lmd.pet.weathernew.utils.NavigationDest

@Immutable
sealed class StartState : UiState {
    object Empty : StartState()
    object Display : StartState()
    data class Navigate(val dest: NavigationDest) : StartState()
}