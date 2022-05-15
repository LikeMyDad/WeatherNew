package lmd.pet.weathernew.ui.screens.general.models

sealed class PermissionAction {
    object PermissionGranted : PermissionAction()
    object PermissionDenied : PermissionAction()
}
