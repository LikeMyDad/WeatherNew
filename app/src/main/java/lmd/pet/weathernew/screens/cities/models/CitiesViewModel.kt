package lmd.pet.weathernew.screens.cities.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import lmd.pet.weathernew.core.base.EventHandler
import lmd.pet.weathernew.domain.useCases.CitiesInteractor
import lmd.pet.weathernew.utils.readOnly
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
    private val citiesUseCase: CitiesInteractor
) : ViewModel(), EventHandler<CitiesEvent> {

    private val mutStateLiveData = MutableLiveData<CitiesState>(CitiesState.Loading)
    val stateLiveData = mutStateLiveData.readOnly()

    override fun obtainEvent(event: CitiesEvent) {
        when(val currentState = mutStateLiveData.value) {
            is CitiesState.Loading -> reduce(event, currentState)
            is CitiesState.Display -> {}
        }
    }

    private fun reduce(event: CitiesEvent, state: CitiesState.Loading) {
        when(event) {
            is CitiesEvent.EnterScreen -> fetchCities()
            else -> {}
        }
    }

    private fun fetchCities() {
        citiesUseCase.execute(
            scope = viewModelScope,
            params = CitiesInteractor.Params(""),
            onComplete = {
                Log.d("GetCities", it.toString())
                mutStateLiveData.postValue(CitiesState.Display(it))
            }
        )
    }
}