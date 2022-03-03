package lmd.pet.weathernew.screens.cities.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lmd.pet.weathernew.data.entity.dao.cities.CityModel

@Composable
fun CityCard(model: CityModel, selectCity: (model: CityModel) -> Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp, horizontal = 2.dp)
        .clickable { selectCity(model) }
    ) {
        Text(text = model.cityName, modifier = Modifier.padding(8.dp), textAlign = TextAlign.Start)
        Text(text = model.timeZone, modifier = Modifier.padding(8.dp), textAlign = TextAlign.End)
    }
}

@Composable
@Preview
fun PreviewCityCard() {
    CityCard(model = CityModel(0, "Test", "123", listOf())) {}
}