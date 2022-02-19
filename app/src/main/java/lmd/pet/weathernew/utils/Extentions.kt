package lmd.pet.weathernew.utils

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

fun <T>MutableStateFlow<T>.readOnly(): StateFlow<T> = this