package lmd.pet.weathernew.ui.screens.cities.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import lmd.pet.weathernew.R
import lmd.pet.weathernew.data.entity.dao.cities.CityModel
import lmd.pet.weathernew.ui.composable.Loading
import lmd.pet.weathernew.ui.screens.cities.models.CitiesState

@Composable
fun CitiesViewDisplay(
    modifier: Modifier,
    viewState: CitiesState.DisplayCities,
    onValueChange: (query: String) -> Unit,
    messageStates: MutableState<String>,
    selectedCity: (CityModel) -> Unit,
    isLoading: Boolean = false
) {

    Surface(modifier = modifier.fillMaxSize()) {
        Column {
            OutlinedTextField(
                value = messageStates.value,
                onValueChange = {
                    onValueChange(it)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.normal_spacing)),
                singleLine = true,
                label = {
                    Text(text = stringResource(id = R.string.start_typing))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_search_24),
                        contentDescription = stringResource(id = R.string.search_field)
                    )
                }
            )

            LazyColumn {
                if (isLoading) {
                    item {
                        Loading()
                    }
                } else {
                    if (viewState.items.isNotEmpty()) {
                        viewState.items.forEach {
                            item {
                                CityCard(
                                    modifier = modifier,
                                    model = it,
                                    selectCity = selectedCity
                                )
                            }
                        }
                    } else {
                        item
                        item {
                            Text(
                                text = stringResource(id = R.string.no_results),
                                modifier = modifier
                                    .fillMaxWidth()
                                    .padding(
                                        horizontal = dimensionResource(
                                            id = R.dimen.normal_spacing
                                        )
                                    ),
                                textAlign = TextAlign.Center
                            )
                        }
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