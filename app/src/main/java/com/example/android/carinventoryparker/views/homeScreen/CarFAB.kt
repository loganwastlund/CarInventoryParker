package com.example.android.carinventoryparker.views.homeScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ElectricCar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.android.carinventoryparker.R

@Composable
fun CarFAB(
    openDialog: () -> Unit
) {
    FloatingActionButton(
        onClick = { openDialog() },
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Icon(
            imageVector = Icons.Default.ElectricCar,
            contentDescription = stringResource(R.string.add_a_car)
        )
    }
}