package lmd.pet.weathernew.ui.screens.main.models

import androidx.compose.runtime.Immutable
import lmd.pet.weathernew.core.base.UiEvent
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.data.entity.response.weather.DailyWeather

@Immutable
sealed class MainEvent : UiEvent {
    object EnterScreen : MainEvent()
    object Loading : MainEvent()

    data class SuccessLoadedWeather(val weather: DailyWeather): MainEvent()
    data class Error(val throwable: Throwable): MainEvent()
}
