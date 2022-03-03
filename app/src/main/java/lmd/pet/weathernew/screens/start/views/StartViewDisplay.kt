package lmd.pet.weathernew.screens.start.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun StartViewDisplay(
    modifier: Modifier,
    navController: NavController
) {
    Surface(modifier = modifier.fillMaxSize()) {
        
    }
}

@Composable
@Preview
fun PreviewStartViewDisplay() {
    StartViewDisplay(modifier = Modifier, navController = rememberNavController())
}