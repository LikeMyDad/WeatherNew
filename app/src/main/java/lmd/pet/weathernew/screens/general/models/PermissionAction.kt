package lmd.pet.weathernew.screens.general.models

sealed class PermissionAction {
    object PermissionGranted : PermissionAction()
    object PermissionDenied : PermissionAction()
}
