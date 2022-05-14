package lmd.pet.weathernew.screens.cities.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.screens.cities.models.CitiesState

@Composable
fun CitiesViewDisplay(
    modifier: Modifier,
    viewState: CitiesState.DisplayCities,
    onValueChange: (query: String) -> Unit,
    messageStates: MutableState<String>,
    selectedCity: (CityModel) -> Unit
) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column {
            OutlinedTextField(
                value = messageStates.value,
                onValueChange = onValueChange,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp)
                    .padding(top = 12.dp)
            )

            LazyColumn {
                viewState.items.forEach {
                    item {
                        CityCard(model = it, selectCity = selectedCity)
                    }
                }
            }
        }
    }

}

@Composable
@Preview
fun PreviewCitiesViewDisplay() {
    val messageStates = remember { mutableStateOf("") }
    CitiesViewDisplay(
        modifier = Modifier,
        viewState = CitiesState.DisplayCities(
            items = listOf(
                CityModel(0, "Test", "GMT+4", listOf())
            )
        ),
        onValueChange = {},
        messageStates = messageStates,
        selectedCity = {}
    )
}