package lmd.pet.weathernew.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import lmd.pet.weathernew.screens.main.models.MainViewModel
import lmd.pet.weathernew.screens.main.views.MainViewDisplay

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MainViewModel
) {
    MainViewDisplay()
}