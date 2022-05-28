package lmd.pet.weathernew.ui.screens.start.models

import kotlinx.coroutines.flow.StateFlow
import lmd.pet.weathernew.core.base.BaseViewModel
import lmd.pet.weathernew.core.base.Reducer
import lmd.pet.weathernew.utils.NavigationDest

class StartViewModel : BaseViewModel<StartState, StartEvent>() {

    private val startReducer =
        object : Reducer<StartState, StartEvent>(initialValue = StartState.Empty) {
            override fun reduce(state: StartState, event: StartEvent) {
                when(event) {
                    is StartEvent.EnterScreen -> setState(StartState.Display)
                    is StartEvent.Navigation -> setState(StartState.Navigate(event.dest))
                    else -> throw Exception("Cant handle StartEvent")
                }
            }
        }

    init {
        sendEvent(StartEvent.EnterScreen)
    }

    override val state: StateFlow<StartState>
        get() = startReducer.stateFlow

    override fun sendEvent(event: StartEvent) {
        startReducer.sendEvent(event)
    }

    fun navigate(dest: NavigationDest) {
        sendEvent(StartEvent.Navigation(dest))
    }
}