package lmd.pet.weathernew.screens.start

import android.Manifest
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import lmd.pet.weathernew.screens.general.models.PermissionAction
import lmd.pet.weathernew.screens.general.views.DefaultSnackbar
import lmd.pet.weathernew.screens.general.views.PermissionView
import lmd.pet.weathernew.screens.start.models.StartEvent
import lmd.pet.weathernew.screens.start.models.StartState
import lmd.pet.weathernew.screens.start.models.StartViewModel
import lmd.pet.weathernew.screens.start.views.StartViewDisplay
import lmd.pet.weathernew.utils.NavigationDest
import lmd.pet.weathernew.utils.navigateByRoute

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: StartViewModel
) {
    val viewState = viewModel.stateLiveData.observeAsState()
    val scaffoldState = rememberScaffoldState()

    StartViewDisplay(
        modifier = modifier
    ) {
        viewModel.obtainEvent(StartEvent.RequestPermission)
    }

    when (val state = viewState.value) {
        is StartState.Permission -> {

            PermissionView(
                permission = Manifest.permission.ACCESS_FINE_LOCATION,
                permissionRational = "Test",
                scaffoldState = scaffoldState
            ) {
                val navigationDest =
                    if (it == PermissionAction.PermissionGranted)
                        NavigationDest.MainScreen
                    else
                        NavigationDest.CitiesScreen

                viewModel.obtainEvent(StartEvent.PermissionChoose(navigationDest))
            }

            DefaultSnackbar(snackbarHostState = scaffoldState.snackbarHostState) {
                scaffoldState.snackbarHostState.currentSnackbarData?.performAction()
            }
        }
        is StartState.Navigate -> {
            Log.d("CheckNavigation", "${state.dest}")
            navController.navigateByRoute(state.dest)
        }
    }

    LaunchedEffect(key1 = viewState) {
        viewModel.obtainEvent(StartEvent.EnterScreen)
    }
}