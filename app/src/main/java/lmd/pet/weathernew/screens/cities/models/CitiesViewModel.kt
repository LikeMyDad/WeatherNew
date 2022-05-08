package lmd.pet.weathernew.screens.cities.models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import lmd.pet.weathernew.core.base.EventHandler
import lmd.pet.weathernew.domain.useCases.CitiesInteractor
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
    private val citiesUseCase: CitiesInteractor
) : ViewModel(), EventHandler<CitiesEvent> {

    private val mutStateLiveData = MutableStateFlow<CitiesState>(CitiesState.Empty)
    val stateLiveData: StateFlow<CitiesState> = mutStateLiveData

    override fun obtainEvent(event: CitiesEvent) {
        when(val currentState = mutStateLiveData.value) {
            is CitiesState.Empty -> reduce(event, currentState)
            is CitiesState.Loading -> reduce(event, currentState)
            is CitiesState.DisplayCities -> reduce(event, currentState)
        }
    }

    private fun reduce(event: CitiesEvent, state: CitiesState.Empty) {
        when(event) {
            is CitiesEvent.EnterScreen -> mutStateLiveData.value = CitiesState.Loading
            else -> {}
        }
    }

    private fun reduce(event: CitiesEvent, state: CitiesState.Loading) {
        when(event) {
            is CitiesEvent.EnterScreen -> fetchCities()
            else -> {}
        }
    }

    private fun reduce(event: CitiesEvent, state: CitiesState.DisplayCities) {
        when(event) {
            is CitiesEvent.EnterScreen -> {
                Log.d("CheckState", "$state")
            }
        }
    }

    private fun fetchCities() {
        mutStateLiveData.value = CitiesState.DisplayCities(emptyList())
//        citiesUseCase.execute(
//            scope = viewModelScope,
//            params = CitiesInteractor.Params(""),
//            onComplete = {
//                Log.d("GetCities", it.toString())
//                mutStateLiveData.value = CitiesState.DisplayCities(it)
//            }
//        )
    }
}