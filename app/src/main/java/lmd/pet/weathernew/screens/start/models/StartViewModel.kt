package lmd.pet.weathernew.screens.start.models

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import lmd.pet.weathernew.core.base.Reducer
import lmd.pet.weathernew.core.base.BaseViewModel
import lmd.pet.weathernew.utils.NavigationDest
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor() : BaseViewModel<StartState, StartEvent>() {

    private val startReducer =
        object : Reducer<StartState, StartEvent>(initialValue = StartState.initial()) {
            override fun reduce(state: StartState, event: StartEvent) {
                when(event) {
                    is StartEvent.EnterScreen -> {}
                    is StartEvent.Navigation -> {}
                }
            }
        }

    override val state: StateFlow<StartState>
        get() = startReducer.stateFlow

    private fun sendEvent(event: StartEvent) {
        startReducer.sendEvent(event)
    }

}