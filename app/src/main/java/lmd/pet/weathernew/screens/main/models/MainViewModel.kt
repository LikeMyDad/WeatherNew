package lmd.pet.weathernew.screens.main.models

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import lmd.pet.weathernew.core.base.EventHandler
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel(), EventHandler<MainEvent> {

    override fun obtainEvent(event: MainEvent) {
        TODO("Not yet implemented")
    }

}