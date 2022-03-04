package lmd.pet.weathernew.screens.cities.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import lmd.pet.weathernew.core.base.EventHandler
import lmd.pet.weathernew.domain.useCases.CitiesInteractor
import lmd.pet.weathernew.screens.cities.models.CitiesEvent
import lmd.pet.weathernew.screens.cities.models.CitiesState
import lmd.pet.weathernew.utils.readOnly
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
    private val citiesUseCase: CitiesInteractor
) : ViewModel(), EventHandler<CitiesEvent> {

    private val mutStateLiveData = MutableLiveData<CitiesState>(CitiesState.Empty)
    val stateLiveData = mutStateLiveData.readOnly()

    override fun obtainEvent(event: CitiesEvent) {
        when(val currentState = mutStateLiveData.value) {
            is CitiesState.Display -> reduce(event, currentState)
        }
    }

    private fun reduce(event: CitiesEvent, state: CitiesState.Loading) {

    }

    private fun reduce(event: CitiesEvent, state: CitiesState.Display) {
        when (event) {
            is CitiesEvent.EnterScreen -> fetchCities()
        }
    }

    private fun fetchCities() {
        citiesUseCase.execute(
            scope = viewModelScope,
            params = CitiesInteractor.Params(""),
            onPreExecute = {
                mutStateLiveData.postValue(CitiesState.Loading)
            },
            onComplete = {
                mutStateLiveData.postValue(CitiesState.Display(it))
            }
        )
    }
}