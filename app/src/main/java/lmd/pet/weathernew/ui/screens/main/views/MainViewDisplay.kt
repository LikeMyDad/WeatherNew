package lmd.pet.weathernew.ui.screens.main.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lmd.pet.weathernew.data.entity.response.weather.DailyWeather

@Composable
fun MainViewDisplay(
    modifier: Modifier,
    dailyWeather: DailyWeather
) {
    Surface(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            item {
                CurrentWeatherCard(
                    modifier = modifier,
                    currentWeather = dailyWeather.current
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
//    MainViewDisplay(modifier = modifier)
}