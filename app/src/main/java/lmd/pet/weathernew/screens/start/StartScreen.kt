package lmd.pet.weathernew.screens.start

import android.Manifest
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import lmd.pet.weathernew.screens.general.models.PermissionAction
import lmd.pet.weathernew.screens.general.views.PermissionView
import lmd.pet.weathernew.screens.start.models.StartEvent
import lmd.pet.weathernew.screens.start.models.StartState
import lmd.pet.weathernew.screens.start.models.StartViewModel
import lmd.pet.weathernew.screens.start.views.StartViewDisplay
import lmd.pet.weathernew.utils.NavigationDest
import lmd.pet.weathernew.utils.navigateByRoute

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: StartViewModel
) {
    val viewState = viewModel.stateLiveData.observeAsState()
    val scaffoldState = rememberScaffoldState()

    when (val state = viewState.value) {
        is StartState.Display -> StartViewDisplay(
            modifier = modifier,
            navController = navController,
            scaffoldState = scaffoldState
        ) {
            viewModel.obtainEvent(StartEvent.Permission)
        }
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

                navController.navigateByRoute(navigationDest)
            }
        }
    }

    LaunchedEffect(key1 = viewState) {
        viewModel.obtainEvent(StartEvent.EnterScreen)
    }
}