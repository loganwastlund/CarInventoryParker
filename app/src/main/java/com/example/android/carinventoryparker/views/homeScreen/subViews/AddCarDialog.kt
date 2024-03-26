package com.example.android.carinventoryparker.views.homeScreen.subViews

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.android.carinventoryparker.R

@Composable
fun AddCarDialog(
    isDialogOpen: Boolean,
    closeDialog: () -> Unit
) {
    if (isDialogOpen) {
        AlertDialog(
            onDismissRequest = { closeDialog() },
            title = {
                Text(stringResource(id = R.string.add_a_car))
            },
            text = {
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        // TODO: Add a car
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
