package lmd.pet.weathernew.ui.screens.main.models

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import lmd.pet.weathernew.core.base.BaseViewModel
import lmd.pet.weathernew.core.base.Reducer
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.domain.useCases.cities.GetCitiesWeatherInteractor
import lmd.pet.weathernew.domain.useCases.weather.GetCityWeatherInteractor

class MainViewModel(
    private val citiesWeatherUseCase: GetCitiesWeatherInteractor,
    private val cityWeatherUseCase: GetCityWeatherInteractor
) : BaseViewModel<MainState, MainEvent>() {

    private val reducer = object : Reducer<MainState, MainEvent>(initialValue = MainState.Empty) {
        override fun reduce(state: MainState, event: MainEvent) {
            when (event) {
                is MainEvent.EnterScreen -> fetchCitiesWeather()
                is MainEvent.Loading -> setState(MainState.Loading)
                is MainEvent.SuccessLoadedWeather ->
                    setState(MainState.DisplayCityWeather(event.weather))
                is MainEvent.Error -> {}
                else -> throw Exception("Cant handle MainEvent")
            }
        }
    }

    override fun sendEvent(event: MainEvent) {
        reducer.sendEvent(event)
    }

    override val state: StateFlow<MainState>
        get() = reducer.stateFlow

    private val mutCitiesStateFlow = MutableStateFlow(emptyList<CityModel>())
    val citiesStateFlow: StateFlow<List<CityModel>> = mutCitiesStateFlow

    init {
        sendEvent(MainEvent.EnterScreen)
    }

    private fun fetchCitiesWeather() {
        citiesWeatherUseCase.execute(
            scope = viewModelScope,
            onPreExecute = {
                sendEvent(MainEvent.Loading)
            },
            onComplete = { cities ->
                mutCitiesStateFlow.value = cities
                getCityWeather(cities.first().id)
            },
            onError = { throwable ->
                sendEvent(MainEvent.Error(throwable))
            }
        )
    }

    private fun getCityWeather(cityId: Int) {
        cityWeatherUseCase.execute(
            params = GetCityWeatherInteractor.Params(cityId = cityId),
            onComplete = { weather ->
                sendEvent(MainEvent.SuccessLoadedWeather(weather))
            }
        )
    }
}