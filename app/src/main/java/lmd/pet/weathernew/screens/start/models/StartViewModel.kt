package lmd.pet.weathernew.screens.start.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import lmd.pet.weathernew.core.base.EventHandler
import lmd.pet.weathernew.domain.useCases.CitiesInteractor
import lmd.pet.weathernew.utils.readOnly
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(

) : ViewModel(), EventHandler<StartState> {



    override fun obtainEvent(event: StartState) {
        TODO("Not yet implemented")
    }

}