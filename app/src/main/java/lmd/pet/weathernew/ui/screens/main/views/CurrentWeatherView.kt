package lmd.pet.weathernew.ui.screens.main.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import lmd.pet.weathernew.data.entity.response.weather.current.CurrentWeather
import lmd.pet.weathernew.data.repositories.image.ImageRepository
import lmd.pet.weathernew.utils.enum.Image
import org.koin.androidx.compose.inject

@Composable
fun CurrentWeatherView(
    modifier: Modifier,
    currentWeather: CurrentWeather,
    cityName: String
) {
    val imageLoader: ImageRepository by inject()

    Row {
        Column(horizontalAlignment = Alignment.End) {
            Text(text = cityName)
            Text(text = currentWeather.temperature.toString())
            Text(text = currentWeather.date.toString())
        }
        AsyncImage(
            model = imageLoader.generateImageUrl(
                iconId = currentWeather.weatherIcon.first().icon,
                size = Image.Size.BIG,
                format = Image.Format.PNG
            ),
            contentDescription = "",
        )
    }
}

@Preview
@Composable
fun CurrentWeatherPreview(
    modifier: Modifier = Modifier,
    currentWeather: CurrentWeather = CurrentWeather.initial(),
    cityName: String = "TestCity"
) {
    CurrentWeatherView(
        modifier = modifier,
        currentWeather = currentWeather,
        cityName = cityName
    )
}