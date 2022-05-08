package lmd.pet.weathernew.screens.start.models

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import lmd.pet.weathernew.core.base.EventHandler
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor() : ViewModel(), EventHandler<StartEvent> {

    private val mutStateLiveData = MutableStateFlow<StartState>(StartState.Empty)
    val stateLiveData: StateFlow<StartState> = mutStateLiveData

    override fun obtainEvent(event: StartEvent) {
        when(val currentState = mutStateLiveData.value) {
            is StartState.Empty -> reduce(event, currentState)
            is StartState.Display -> reduce(event, currentState)
            is StartState.Permission -> reduce(event, currentState)
        }
    }

    private fun reduce(event: StartEvent, state: StartState.Empty) {
        when(event) {
            is StartEvent.EnterScreen -> mutStateLiveData.value = StartState.Display
            else -> {}
        }
    }

    private fun reduce(event: StartEvent, state: StartState.Display) {
        when(event) {
            is StartEvent.EnterScreen -> {}
            is StartEvent.Permission -> mutStateLiveData.value = StartState.Permission
            else -> {}
        }
    }

    private fun reduce(event: StartEvent, state: StartState.Permission) {
        when(event) {
            is StartEvent.Navigation -> mutStateLiveData.value = StartState.Navigate(event.dest)
            else -> {}
        }
    }

}