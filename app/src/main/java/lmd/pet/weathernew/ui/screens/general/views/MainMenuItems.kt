package lmd.pet.weathernew.ui.screens.general.views

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.navigation.NavController
import lmd.pet.weathernew.utils.NavigationDest

@Composable
fun MainMenuItems(
    title: String,
    navController: NavController
) {
    var showMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(title) },
        actions = {
            IconButton(onClick = { showMenu = true }) {
                Icon(Icons.Filled.Menu, "Menu")
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
            ) {
                DropdownMenuItem(
                    onClick = {
                        showMenu = false
                        navController.navigate(NavigationDest.SettingScreen.name)
                    }
                ) {
                    Text(text = "Settings")
                }
            }
        }
    )
}