package lmd.pet.weathernew.screens.start.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import lmd.pet.weathernew.core.base.EventHandler
import lmd.pet.weathernew.utils.readOnly
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor() : ViewModel(), EventHandler<StartEvent> {

    private val mutStateLiveData = MutableLiveData<StartState>(StartState.Display)
    val stateLiveData = mutStateLiveData.readOnly()

    override fun obtainEvent(event: StartEvent) {
        when(val currentState = mutStateLiveData.value) {
            is StartState.Display -> reduce(event, currentState)
            is StartState.Permission -> reduce(event, currentState)
        }
    }

    private fun reduce(event: StartEvent, state: StartState.Display) {
        when(event) {
            is StartEvent.RequestPermission -> mutStateLiveData.postValue(StartState.Permission)
            else -> {}
        }
    }

    private fun reduce(event: StartEvent, state: StartState.Permission) {
        when(event) {
            is StartEvent.PermissionChoose -> mutStateLiveData.postValue(StartState.Navigate(event.dest))
            else -> {}
        }
    }

}