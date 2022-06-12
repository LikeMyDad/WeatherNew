package lmd.pet.weathernew.ui.screens.start

import android.Manifest
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.navArgument
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import lmd.pet.weathernew.ui.screens.start.models.StartState
import lmd.pet.weathernew.ui.screens.start.models.StartViewModel
import lmd.pet.weathernew.ui.screens.start.views.StartViewDisplay
import lmd.pet.weathernew.utils.NavigationDest
import java.lang.Exception

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: StartViewModel
) {
    val viewState by viewModel.state.collectAsState()

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
        is StartState.Display -> StartViewDisplay(
            modifier = modifier
        ) { multiplePermissionsState.launchMultiplePermissionRequest() }
        is StartState.Navigate -> {
            LaunchedEffect(key1 = Unit) {
                navController.navigate(state.dest.name)
            }
        }
        else -> throw Exception("Cant handle StartState")
    }


}