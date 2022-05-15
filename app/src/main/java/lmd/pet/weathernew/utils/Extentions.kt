package lmd.pet.weathernew.utils

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

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