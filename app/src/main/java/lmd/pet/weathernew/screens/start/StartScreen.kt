package lmd.pet.weathernew.screens.start

import android.Manifest
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
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

    val locationPermissionsState = rememberMultiplePermissionsState(
        listOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
        )
    )

    StartViewDisplay(
        modifier = modifier
    ) {
        viewModel.obtainEvent(StartEvent.RequestPermission)
    }

    when (val state = viewState.value) {
        is StartState.Permission -> {

            val navigationDest =
                if (locationPermissionsState.allPermissionsGranted)
                    NavigationDest.MainScreen
                else
                    NavigationDest.CitiesScreen

            SideEffect {
                locationPermissionsState.launchMultiplePermissionRequest()
            }

            viewModel.obtainEvent(StartEvent.PermissionChoose(navigationDest))
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