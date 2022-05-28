package lmd.pet.weathernew.ui.screens.main.views

import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import lmd.pet.weathernew.data.entity.response.weather.current.CurrentWeather
import org.koin.androidx.compose.get
import org.koin.core.qualifier.named

@Composable
fun CurrentWeatherCard(
    modifier: Modifier,
    currentWeather: CurrentWeather
) {
    val baseIconUrl = get<String>(named("WeatherIconUrl"))

    Card {
        AsyncImage(
            model = baseIconUrl + currentWeather.weatherIcon.first().icon + ".png",
            contentDescription = "",
            modifier = modifier.size(75.dp)
        )
    }
}