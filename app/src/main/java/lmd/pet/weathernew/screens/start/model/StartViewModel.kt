package lmd.pet.weathernew.screens.start.model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import lmd.pet.weathernew.domain.useCases.CitiesInteractor
import lmd.pet.weathernew.screens.start.StartState
import lmd.pet.weathernew.utils.readOnly
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val citiesUseCase: CitiesInteractor
) : ViewModel() {

    private val mutUiStateFlow = MutableStateFlow<StartState>(StartState.Empty)
    val uiStateFlow = mutUiStateFlow.readOnly()

    init {
        citiesUseCase.execute(
            scope = viewModelScope,
            params = CitiesInteractor.Params(""),
            onPreExecute = {
                mutUiStateFlow.value = StartState.Loading
            },
            onComplete = {
                Log.d("CheckCities", ": $it")
            }
        )
    }

}