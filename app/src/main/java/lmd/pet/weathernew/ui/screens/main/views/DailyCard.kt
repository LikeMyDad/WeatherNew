package lmd.pet.weathernew.ui.screens.main.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import lmd.pet.weathernew.data.entity.response.weather.daily.day.DailyDayWeather
import lmd.pet.weathernew.data.repositories.image.ImageRepository
import lmd.pet.weathernew.utils.enum.Image
import lmd.pet.weathernew.utils.formatUnixTime
import org.koin.androidx.compose.inject

@Composable
fun DailyItemView(
    modifier: Modifier,
    dailyDayWeather: DailyDayWeather
) {
    val imageLoader: ImageRepository by inject()

    Row(modifier = modifier.fillMaxWidth()) {
        Text(text = formatUnixTime(dailyDayWeather.date, "E"))
        AsyncImage(
            model = imageLoader.generateImageUrl(
                iconId = dailyDayWeather.weather.first().icon,
                size = Image.Size.NORMAL,
                format = Image.Format.PNG
            ),
            contentDescription = "",
            modifier = modifier.padding(start = 12.dp)
        )
        Text(
            text = dailyDayWeather.temperature.day.toString(),
            textAlign = TextAlign.End
        )
    }
}