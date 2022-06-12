package lmd.pet.weathernew.ui.screens.start.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lmd.pet.weathernew.R

@Composable
fun StartViewDisplay(
    modifier: Modifier,
    onButtonLocationClick: () -> Unit
) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_weather_playstore),
                contentDescription = null,
                alignment = Alignment.Center,
                modifier = modifier.size(dimensionResource(id = R.dimen.large_icon_size))
            )
            Text(
                text = stringResource(id = R.string.text_location_permission),
                modifier = modifier.padding(dimensionResource(id = R.dimen.normal_spacing)),
                textAlign = TextAlign.Center
            )
            Button(
                onClick = onButtonLocationClick,
                modifier = modifier.padding(top = dimensionResource(id = R.dimen.regular_spacing)),
            ) {
                Text(text = stringResource(id = R.string.start))
            }
        }
    }
}

@Composable
@Preview
fun PreviewStartViewDisplay() {
    StartViewDisplay(
        modifier = Modifier
    ) {}
}