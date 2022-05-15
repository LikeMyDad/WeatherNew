package lmd.pet.weathernew.ui.screens.start.models

import androidx.compose.runtime.Immutable
import lmd.pet.weathernew.core.base.UiEvent
import lmd.pet.weathernew.utils.NavigationDest

@Immutable
sealed class StartEvent : UiEvent {
    object EnterScreen : StartEvent()
    data class Navigation(val dest: NavigationDest) : StartEvent()
}
