package lmd.pet.weathernew.ui.screens.main.models

import androidx.compose.runtime.Immutable
import lmd.pet.weathernew.core.base.UiState
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.data.entity.response.weather.DailyWeather

@Immutable
sealed class MainState : UiState {
    object Empty : MainState()
    object Loading : MainState()
    data class DisplayCityWeather(val weather: DailyWeather) : MainState()
}
