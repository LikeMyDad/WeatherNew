package lmd.pet.weathernew.screens.cities

import android.util.Log
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

    private val mutUiStateFlow = MutableLiveData<CitiesState>(CitiesState.Empty)
    val uiStateFlow = mutUiStateFlow.readOnly()

    init {
        citiesUseCase.execute(
            scope = viewModelScope,
            params = CitiesInteractor.Params(""),
            onPreExecute = {
                mutUiStateFlow.value = CitiesState.Loading
            },
            onComplete = {
                Log.d("CheckCities", ": $it")
            }
        )
    }

    override fun obtainEvent(event: CitiesEvent) {
        when(event) {

        }
    }

}