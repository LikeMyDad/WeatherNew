package lmd.pet.weathernew.screens.start

import android.util.Log
import androidx.compose.material.rememberScaffoldState
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

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: StartViewModel
) {
    val viewState = viewModel.stateLiveData.observeAsState()
    val scaffoldState = rememberScaffoldState()

    val multiplePermissionsState = rememberMultiplePermissionsState(
        listOf(
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.CAMERA,
        )
    )

    Log.d("StartScreen", "Start")

    StartViewDisplay(
        modifier = modifier
    ) {
        multiplePermissionsState.launchMultiplePermissionRequest()
    }

    when (val state = viewState.value) {
        is StartState.Permission -> {

//            if (multiplePermissionsState.allPermissionsGranted) {
//                viewModel.obtainEvent(StartEvent.PermissionChoose(NavigationDest.MainScreen))
//            } else {
//                viewModel.obtainEvent(StartEvent.PermissionChoose(NavigationDest.CitiesScreen))
//            }
        }
        is StartState.Navigate -> {
            navController.navigate(state.dest.screen)
        }
    }

    LaunchedEffect(key1 = viewState) {
        viewModel.obtainEvent(StartEvent.EnterScreen)
    }
}

//
//PermissionView(
//permission = Manifest.permission.ACCESS_FINE_LOCATION,
//permissionRational = "Test",
//scaffoldState = scaffoldState
//) {
//    navController.navigate(NavigationDest.CitiesScreen.screen)
//                val navigationDest =
//                    if (it == PermissionAction.PermissionGranted)
//                        NavigationDest.MainScreen
//                    else
//                        NavigationDest.CitiesScreen
//
//                viewModel.obtainEvent(StartEvent.PermissionChoose(navigationDest))
//}

//            DefaultSnackbar(snackbarHostState = scaffoldState.snackbarHostState) {
//                scaffoldState.snackbarHostState.currentSnackbarData?.performAction()
//            }