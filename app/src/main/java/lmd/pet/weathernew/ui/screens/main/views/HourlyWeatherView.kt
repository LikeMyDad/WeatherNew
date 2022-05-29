package lmd.pet.weathernew.ui.screens.main.views

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import lmd.pet.weathernew.data.entity.response.weather.daily.hour.HourlyWeather

@Composable
fun HourlyWeatherView(
    modifier: Modifier,
    hourlyWeatherList: List<HourlyWeather>
) {
    LazyRow {
        items(hourlyWeatherList) { hourlyWeather ->
            HourlyCard(modifier = modifier, hourlyWeather = hourlyWeather)
        }
    }
}