package lmd.pet.weathernew.screens.start.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import lmd.pet.weathernew.core.base.EventHandler
import lmd.pet.weathernew.utils.readOnly
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor() : ViewModel(), EventHandler<StartEvent> {

    private val mutStateLiveData = MutableLiveData(StartState.Empty)
    val stateLiveData = mutStateLiveData.readOnly()

    override fun obtainEvent(event: StartEvent) {
        TODO("Not yet implemented")
    }

}