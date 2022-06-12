package lmd.pet.weathernew.ui.screens.cities.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import lmd.pet.weathernew.R
import lmd.pet.weathernew.data.entity.dao.cities.CityModel

@Composable
fun CityCard(modifier: Modifier, model: CityModel, selectCity: (model: CityModel) -> Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .size(dimensionResource(id = R.dimen.city_card_size))
            .padding(dimensionResource(id = R.dimen.very_small_spacing))
            .clickable { selectCity(model) }
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = model.cityName,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.small_spacing)),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = model.timeZone,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.small_spacing))
            )
        }
    }
}

@Composable
@Preview
fun PreviewCityCard() {
    CityCard(
        modifier = Modifier,
        model = CityModel(0, "Test", "123", listOf())
    ) {}
}