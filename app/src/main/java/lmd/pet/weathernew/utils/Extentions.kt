package lmd.pet.weathernew.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

fun <T>MutableStateFlow<T>.readOnly(): StateFlow<T> = this

fun <T>MutableLiveData<T>.readOnly(): LiveData<T> = this