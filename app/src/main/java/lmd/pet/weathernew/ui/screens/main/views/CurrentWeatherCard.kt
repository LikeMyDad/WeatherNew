package lmd.pet.weathernew.ui.screens.main.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Surface
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
    val imageRepository: ImageRepository by inject()

    Row(modifier = modifier.wrapContentSize()) {
        Column {
            Text(text = cityName)
        }
        AsyncImage(
            model = imageRepository.generateImageUrl(
                iconId = currentWeather.weatherIcon.first().icon,
                size = Image.Size.BIG,
                format = Image.Format.PNG
            ),
            contentDescription = "",
            alignment = Alignment.CenterEnd
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
