package lmd.pet.weathernew.core.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<T: UiState, in E: UiEvent>: ViewModel() {
    abstract val state: StateFlow<T>
}