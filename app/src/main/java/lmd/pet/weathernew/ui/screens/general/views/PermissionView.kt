package lmd.pet.weathernew.ui.screens.general.views

import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import lmd.pet.weathernew.ui.screens.general.models.PermissionAction
import lmd.pet.weathernew.utils.checkPermissionForGranted
import lmd.pet.weathernew.utils.shouldShowPermissionRationale

@Composable
fun PermissionView(
    context: Context = LocalContext.current,
    permission: String,
    permissionRational: String,
    scaffoldState: ScaffoldState,
    permissionAction: (PermissionAction) -> Unit
) {
    val permissionGranted = context.checkPermissionForGranted(permission)

    if (permissionGranted) {
        permissionAction(PermissionAction.PermissionGranted)
    }

    val launcher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            val actionForPermission =
                if (isGranted)
                    PermissionAction.PermissionGranted
                else
                    PermissionAction.PermissionDenied

            permissionAction(actionForPermission)
        }

    val showPermissionRationale = context.shouldShowPermissionRationale(permission)

    if (showPermissionRationale) {
        LaunchedEffect(showPermissionRationale) {
            val snackBarResult = scaffoldState.snackbarHostState.showSnackbar(
                message = permissionRational,
                actionLabel = "Grant Access",
                duration = SnackbarDuration.Long
            )
            when(snackBarResult) {
                SnackbarResult.Dismissed -> permissionAction(PermissionAction.PermissionDenied)
                SnackbarResult.ActionPerformed -> launcher.launch(permission)
            }
        }
    } else {
        SideEffect {
            launcher.launch(permission)
        }
    }
}