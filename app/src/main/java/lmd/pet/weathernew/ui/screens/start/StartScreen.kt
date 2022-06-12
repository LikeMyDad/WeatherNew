package lmd.pet.weathernew.ui.screens.start

import android.Manifest
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import lmd.pet.weathernew.ui.screens.start.models.StartState
import lmd.pet.weathernew.ui.screens.start.models.StartViewModel
import lmd.pet.weathernew.ui.screens.start.views.AlertDialogLocationDisplay
import lmd.pet.weathernew.ui.screens.start.views.StartViewDisplay
import lmd.pet.weathernew.utils.NavigationDest

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: StartViewModel
) {
    val viewState by viewModel.state.collectAsState()
    val dialogAlert = remember { mutableStateOf(false) }

    val multiplePermissionsState = rememberMultiplePermissionsState(
        listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        )
    ) {
        val navigationDest = if (it.containsValue(true)) {
            NavigationDest.MainScreen
        } else {
            NavigationDest.CitiesScreen
        }

        viewModel.navigate(navigationDest)
    }

    when (val state = viewState) {
        is StartState.Display -> {
            StartViewDisplay(
                modifier = modifier
            ) { dialogAlert.value = true }

            if (dialogAlert.value) {
                AlertDialogLocationDisplay(
                    modifier = modifier,
                    dialogAlert = dialogAlert,
                    onAllowClick = {
                        multiplePermissionsState.launchMultiplePermissionRequest()
                    },
                    onDismissClick = {
                        viewModel.navigate(NavigationDest.CitiesScreen)
                    }
                )
            }
        }
        is StartState.Navigate -> {
            LaunchedEffect(key1 = Unit) {
                navController.navigate(state.dest.name)
            }
        }
        else -> throw Exception("Cant handle StartState")
    }


}