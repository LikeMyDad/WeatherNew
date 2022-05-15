package lmd.pet.weathernew.ui.screens.cities.models

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import lmd.pet.weathernew.core.base.BaseViewModel
import lmd.pet.weathernew.core.base.Reducer
import lmd.pet.weathernew.domain.useCases.cities.GetCitiesInteractor
import lmd.pet.weathernew.domain.useCases.cities.SetStateToShowCityWeatherInteractor
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
    private val citiesUseCase: GetCitiesInteractor,
    private val setStateToShowCityWeatherUseCase: SetStateToShowCityWeatherInteractor
) : BaseViewModel<CitiesState, CitiesEvent>() {

    private val citiesReducer =
        object : Reducer<CitiesState, CitiesEvent>(initialValue = CitiesState.Empty) {
            override fun reduce(state: CitiesState, event: CitiesEvent) {
                when (event) {
                    is CitiesEvent.EnterScreen -> setState(CitiesState.Loading)
                    is CitiesEvent.SearchCities -> fetchCities(event.query)
                    is CitiesEvent.DisplayCities -> setState(CitiesState.DisplayCities(event.cities))
                    is CitiesEvent.SelectCity -> setCityWeather(event.id)
                    is CitiesEvent.Navigate -> setState(CitiesState.Navigate)
                }
            }
        }

    override val state: StateFlow<CitiesState>
        get() = citiesReducer.stateFlow

    init {
        sendEvent(CitiesEvent.EnterScreen)
        citiesFirstInit()
    }

    override fun sendEvent(event: CitiesEvent) {
        citiesReducer.sendEvent(event)
    }

    fun searchCitiesByQuery(query: String) {
        sendEvent(CitiesEvent.SearchCities(query))
    }

    fun selectCity(cityId: Int) {
        sendEvent(CitiesEvent.SelectCity(cityId))
    }

    private fun citiesFirstInit() {
        searchCitiesByQuery(NO_QUERY)
    }

    private fun setCityWeather(cityId: Int) {
        setStateToShowCityWeatherUseCase.execute(
            scope = viewModelScope,
            params = SetStateToShowCityWeatherInteractor.Params(cityId, isShowWeather = true),
            onComplete = {
                sendEvent(CitiesEvent.Navigate)
            }
        )
    }

    private fun fetchCities(query: String) {
        citiesUseCase.execute(
            scope = viewModelScope,
            params = GetCitiesInteractor.Params(query),
            onComplete = { cities ->
                sendEvent(CitiesEvent.DisplayCities(cities))
            }
        )
    }

    companion object {
        private const val NO_QUERY = ""
    }
}