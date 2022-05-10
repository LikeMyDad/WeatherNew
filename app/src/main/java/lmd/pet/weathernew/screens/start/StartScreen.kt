package lmd.pet.weathernew.screens.start

import android.Manifest
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import lmd.pet.weathernew.screens.start.models.StartViewModel
import lmd.pet.weathernew.screens.start.views.StartViewDisplay
import lmd.pet.weathernew.utils.NavigationDest

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: StartViewModel
) {
    val multiplePermissionsState = rememberMultiplePermissionsState(
        listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        )
    ) {
        val navigationDest = if (it.containsValue(true)) {
            NavigationDest.MainScreen
        } else NavigationDest.CitiesScreen

        navController.navigate(navigationDest.name)
    }

    StartViewDisplay(
        modifier = modifier
    ) { multiplePermissionsState.launchMultiplePermissionRequest() }
}