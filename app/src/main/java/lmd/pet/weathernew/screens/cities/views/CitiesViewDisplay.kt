package lmd.pet.weathernew.screens.cities.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.screens.cities.models.CitiesState

@Composable
fun CitiesViewDisplay(
    modifier: Modifier,
    navController: NavController,
    viewState: CitiesState.Display
) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column {
            TextField(
                value = "",
                onValueChange = {},
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 16.dp)
            )

            LazyColumn {
                viewState.items.forEach {
                    item {
                        CityCard(model = it, selectCity = {})
                    }
                }
            }
        }
    }

}

@Composable
@Preview
fun PreviewCitiesViewDisplay() {
    CitiesViewDisplay(
        modifier = Modifier,
        navController = rememberNavController(),
        viewState = CitiesState.Display(
            items = listOf(
                CityModel(0, "Test", "GMT+3", listOf())
            )
        )
    )
}