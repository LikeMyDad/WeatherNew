package lmd.pet.weathernew.ui.screens.main.views

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.data.entity.response.weather.DailyWeather

@Composable
fun MainViewDisplay(
    modifier: Modifier,
    dailyWeather: DailyWeather,
    currentCity: CityModel
) {
    Surface(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            item {
                CurrentWeatherView(
                    modifier = modifier,
                    currentWeather = dailyWeather.current,
                    cityName = currentCity.cityName
                )
            }
            item {
                HourlyWeatherView(
                    modifier = modifier,
                    hourlyWeatherList = dailyWeather.hourly
                )
            }
            item {
                DailyWeatherView(
                    modifier = modifier,
                    dailyWeatherList = dailyWeather.daily
                )
            }
        }
    }
}

@Composable
@Preview
fun MainViewDisplayPreview(
    modifier: Modifier = Modifier
) {
//    MainViewDisplay(
//        modifier = modifier,
//        dailyWeather = DailyWeather.initial(),
//        currentCity = CityModel.initial()
//    )
}