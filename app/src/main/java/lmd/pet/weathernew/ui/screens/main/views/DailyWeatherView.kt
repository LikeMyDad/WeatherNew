package lmd.pet.weathernew.ui.screens.main.views

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import lmd.pet.weathernew.data.entity.response.weather.daily.day.DailyDayWeather

@Composable
fun DailyWeatherView(
    modifier: Modifier,
    dailyWeatherList: List<DailyDayWeather>
) {
    LazyColumn(userScrollEnabled = false, modifier = modifier.size(300.dp)) {
        items(dailyWeatherList) { dailyWeather ->
            DailyItemView(modifier = modifier, dailyDayWeather = dailyWeather)
        }
    }
}