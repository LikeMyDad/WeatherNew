package lmd.pet.weathernew.ui.screens.start.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import lmd.pet.weathernew.R

@Composable
fun AlertDialogLocationDisplay(
    modifier: Modifier,
    dialogAlert: MutableState<Boolean>,
    onAllowClick: () -> Unit,
    onDismissClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { dialogAlert.value = false },
        title = { Text(text = stringResource(id = R.string.title_alert_permission)) },
        text = { Text(text = stringResource(id = R.string.text_alert_permission)) },
        buttons = {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(id = R.dimen.normal_spacing))
                    .padding(bottom = dimensionResource(id = R.dimen.regular_spacing)),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(onClick = {
                    dialogAlert.value = false
                    onDismissClick()
                }, modifier = modifier) {
                    Text(text = stringResource(id = R.string.do_not_allow))
                }
                TextButton(
                    onClick = {
                        dialogAlert.value = false
                        onAllowClick()
                    }
                ) {
                    Text(text = stringResource(id = R.string.allow))
                }
            }
        }
    )
}

@Composable
@Preview
fun AlertDialogLocationDisplayPreview(
    modifier: Modifier = Modifier,
    dialogAlert: MutableState<Boolean> = mutableStateOf(true),
    onAllowClick: () -> Unit = {},
    onDismissClick: () -> Unit = {}
) {
    AlertDialogLocationDisplay(
        modifier = modifier,
        dialogAlert = dialogAlert,
        onAllowClick = onAllowClick,
        onDismissClick = onDismissClick
    )
}