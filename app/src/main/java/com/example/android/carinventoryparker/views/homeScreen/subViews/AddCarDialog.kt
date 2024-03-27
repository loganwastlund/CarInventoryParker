package com.example.android.carinventoryparker.views.homeScreen.subViews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.android.carinventoryparker.R
import com.example.android.carinventoryparker.model.entity.Car
import com.example.android.carinventoryparker.utlities.capitalizeWords
import kotlinx.coroutines.job

@Composable
fun AddCarDialog(
    isDialogOpen: Boolean,
    closeDialog: () -> Unit,
    addCar: (Car) -> Unit,
) {
    if (isDialogOpen) {
        var make by remember { mutableStateOf("") }
        var model by remember { mutableStateOf("") }
        var year by remember { mutableStateOf("") }
        var color by remember { mutableStateOf("") }

        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = { closeDialog() },
            title = {
                Text(stringResource(id = R.string.add_a_car))
            },
            text = {
                Column(
                    modifier = Modifier
                        .height(LocalConfiguration.current.screenHeightDp.dp / 3f),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    LaunchedEffect(key1 = Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    OutlinedTextField(
                        modifier = Modifier
                            .focusRequester(focusRequester),
                        value = make,
                        onValueChange = { make = it },
                        placeholder = { Text(stringResource(R.string.make)) }
                    )
                    OutlinedTextField(
                        value = model,
                        onValueChange = { model = it },
                        placeholder = { Text(stringResource(R.string.model)) }
                    )
                    OutlinedTextField(
                        value = year,
                        onValueChange = { year = it },
                        placeholder = { Text(stringResource(R.string.year)) }
                    )
                    OutlinedTextField(
                        value = color,
                        onValueChange = { color = it },
                        placeholder = { Text(stringResource(R.string.color)) }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        make = capitalizeWords(make)
                        model = capitalizeWords(model)
                        year = capitalizeWords(year)
                        color = capitalizeWords(color)
                        addCar(Car(0, make, model, year, color))
                    }
                ) {
                    Text(stringResource(R.string.add))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                    }
                ) {
                    Text(stringResource(R.string.dismiss))
                }
            },
        )
    }
}
