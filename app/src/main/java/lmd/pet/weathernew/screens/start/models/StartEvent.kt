package lmd.pet.weathernew.screens.start.models

import lmd.pet.weathernew.utils.NavigationDest

sealed class StartEvent {
    object EnterScreen : StartEvent()
    object RequestPermission : StartEvent()
    data class PermissionChoose(val dest: NavigationDest) : StartEvent()
}
