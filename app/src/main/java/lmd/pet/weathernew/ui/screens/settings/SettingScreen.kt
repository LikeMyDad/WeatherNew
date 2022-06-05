package lmd.pet.weathernew.ui.screens.settings

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lmd.pet.weathernew.R
import lmd.pet.weathernew.utils.LocaleUtils

@Composable
fun SettingScreen(
    modifier: Modifier = Modifier,
    callback: (Configuration) -> Unit = {}
) {
    val context = LocalContext.current
    var rememberChecked by remember { mutableStateOf(false) }
    Column(modifier = modifier.fillMaxSize()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp)
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = stringResource(id = R.string.language))
            Switch(
                checked = rememberChecked,
                onCheckedChange = {
                    rememberChecked = it

                    val leng = if (it) "ru" else "en"

                    callback(LocaleUtils(context).updateResources(leng))
                }
            )
        }
    }
}

@Composable
@Preview
fun SettingScreenPreview(
    modifier: Modifier = Modifier
) {
    SettingScreen(modifier)
}