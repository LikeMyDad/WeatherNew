package lmd.pet.weathernew.utils

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.runtime.Composable
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.lang.NullPointerException

fun <T> MutableStateFlow<T>.readOnly(): StateFlow<T> = this

fun <T> MutableLiveData<T>.readOnly(): LiveData<T> = this

fun Context.checkPermissionForGranted(permission: String): Boolean {
    return ContextCompat.checkSelfPermission(this, permission) ==
            PackageManager.PERMISSION_GRANTED
}

fun Context.shouldShowPermissionRationale(permission: String): Boolean {
    val activity = this as? Activity
    return activity?.let {
        ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)
    } ?: throw NullPointerException("Activity is null")
}

@Composable
fun NavHostByRoute(
    navController: NavHostController,
    startDestination: NavigationDest,
    block: (NavGraphBuilder) -> Unit
) {
    NavHost(navController = navController, startDestination = startDestination.dest) {
        block(this)
    }
}

fun NavController.navigateByRoute(
    destination: NavigationDest
) =  navigate(destination.dest)