package lmd.pet.weathernew.screens.start

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import lmd.pet.weathernew.screens.start.models.StartEvent
import lmd.pet.weathernew.screens.start.models.StartState
import lmd.pet.weathernew.screens.start.models.StartViewModel
import lmd.pet.weathernew.screens.start.views.StartViewDisplay
import lmd.pet.weathernew.utils.NavigationDest

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: StartViewModel,
    multiplePermissionsState: MultiplePermissionsState
) {
    val viewState by viewModel.stateLiveData.collectAsState()

    when (val state = viewState) {
        is StartState.Display -> {
            StartViewDisplay(
                modifier = modifier
            ) {
                multiplePermissionsState.launchMultiplePermissionRequest()
            }

            if (multiplePermissionsState.revokedPermissions.isEmpty()
                || multiplePermissionsState.shouldShowRationale
            ) {
                viewModel.obtainEvent(StartEvent.Permission)
            }
        }
        is StartState.Permission -> {
            if (multiplePermissionsState.allPermissionsGranted) {
                viewModel.obtainEvent(StartEvent.Navigation(NavigationDest.MainScreen))
            } else {
                viewModel.obtainEvent(StartEvent.Navigation(NavigationDest.CitiesScreen))
            }
        }
        is StartState.Navigate -> {
            navController.navigate(state.dest.screen)
        }
    }

    LaunchedEffect(key1 = viewState) {
        viewModel.obtainEvent(StartEvent.EnterScreen)
    }
}