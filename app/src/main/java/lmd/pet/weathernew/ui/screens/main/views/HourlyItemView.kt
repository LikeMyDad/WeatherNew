package lmd.pet.weathernew.ui.screens.main.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import lmd.pet.weathernew.data.entity.response.weather.daily.hour.HourlyWeather
import lmd.pet.weathernew.data.repositories.image.ImageRepository
import lmd.pet.weathernew.utils.enum.Image
import lmd.pet.weathernew.utils.formatUnixTime
import org.koin.androidx.compose.inject

@Composable
fun HourlyCard(
    modifier: Modifier,
    hourlyWeather: HourlyWeather
) {
    val imageLoader: ImageRepository by inject()

    Card(modifier = modifier.padding(horizontal = 3.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = formatUnixTime(pattern = "H", unix = hourlyWeather.date),
                textAlign = TextAlign.Center
            )
            AsyncImage(
                model = imageLoader.generateImageUrl(
                    iconId = hourlyWeather.weather.first().icon,
                    size = Image.Size.NORMAL,
                    format = Image.Format.PNG,
                ),
                contentDescription = ""
            )
            Text(text = hourlyWeather.temperature.toString())
        }
    }
}

@Preview
@Composable
fun HourlyCardPreview(
    modifier: Modifier = Modifier,
    hourlyWeather: HourlyWeather = HourlyWeather.initial()
) {
    HourlyCard(modifier = modifier, hourlyWeather = hourlyWeather)
}