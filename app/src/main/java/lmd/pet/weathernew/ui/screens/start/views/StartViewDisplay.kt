package lmd.pet.weathernew.ui.screens.start.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                contentDescription = "",
                alignment = Alignment.Center,
                modifier = modifier.size(124.dp)
            )
            Text(text = stringResource(id = R.string.welcome_title), modifier = modifier.padding(8.dp))
            Button(
                onClick = onButtonLocationClick,
                modifier = modifier.padding(top = 12.dp)
            ) {
                Text(text = "Test")
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