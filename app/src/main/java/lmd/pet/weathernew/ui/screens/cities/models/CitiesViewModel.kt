package lmd.pet.weathernew.ui.screens.cities.models

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import lmd.pet.weathernew.core.base.BaseViewModel
import lmd.pet.weathernew.core.base.Reducer
import lmd.pet.weathernew.domain.useCases.cities.GetCitiesInteractor
import lmd.pet.weathernew.domain.useCases.cities.SetStateToShowCityWeatherInteractor

class CitiesViewModel(
    private val citiesUseCase: GetCitiesInteractor,
    private val setStateToShowCityWeatherUseCase: SetStateToShowCityWeatherInteractor
) : BaseViewModel<CitiesState, CitiesEvent>() {

    private val citiesReducer =
        object : Reducer<CitiesState, CitiesEvent>(initialValue = CitiesState.Empty) {
            override fun reduce(state: CitiesState, event: CitiesEvent) {
                when (event) {
                    is CitiesEvent.EnterScreen -> setState(CitiesState.Loading)
                    is CitiesEvent.SearchCities -> fetchCities(event.query, page)
                    is CitiesEvent.LoadNextPageCities -> fetchCities(savedQuery, event.page)
                    is CitiesEvent.DisplayCities -> setState(CitiesState.DisplayCities(event.cities))
                    is CitiesEvent.SelectCity -> setCityWeather(event.id)
                    is CitiesEvent.Navigate -> setState(CitiesState.Navigate)
                }
            }
        }

    private val mutLoading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = mutLoading

    private var page: Int = 0
    private var savedQuery: String = ""

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

    fun loadNextPageCities() {
        page++
        sendEvent(CitiesEvent.LoadNextPageCities(page))
    }

    private fun fetchCities(query: String, page: Int) {
        citiesUseCase.execute(
            scope = viewModelScope,
            params = GetCitiesInteractor.Params(query, page),
            onPreExecute = {
                mutLoading.value = true
            },
            onComplete = { cities ->
                sendEvent(CitiesEvent.DisplayCities(cities))
            },
            onPostExecute = {
                mutLoading.value = false
            }
        )
    }

    companion object {
        private const val NO_QUERY = ""
    }
}