package lmd.pet.weathernew.core.base

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class Reducer<S: UiState, E: UiEvent>(initialValue: S) {

    private val mutStateFlow = MutableStateFlow(initialValue)
    val stateFlow: StateFlow<S> = mutStateFlow

    fun sendEvent(event: E) {
        reduce(mutStateFlow.value, event)
    }

    fun setState(state: S) {
        mutStateFlow.tryEmit(state)
    }

    abstract fun reduce(state: S, event: E)

}