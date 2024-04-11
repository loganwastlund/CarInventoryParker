package com.example.android.carinventoryparker.feature_carList.presentation.updateScreen.subviews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.android.carinventoryparker.R
import com.example.android.carinventoryparker.feature_carList.domain.model.Car

@Composable
fun UpdateCarContent(
    paddingValues: PaddingValues,
    car: Car,
    updateMake: (make: String) -> Unit,
    updateModel: (model: String) -> Unit,
    updateYear: (year: String) -> Unit,
    updateColor: (color: String) -> Unit,
    updateCar: (car: Car) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        OutlinedTextField(
            value = car.make,
            onValueChange = { updateMake(it) },
            placeholder = {
                Text(stringResource(R.string.car_make))
            }

        )
        Spacer(modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = car.model,
            onValueChange = { updateMake(it) },
            placeholder = {
                Text(stringResource(R.string.car_model))
            }

        )
        Spacer(modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = car.year,
            onValueChange = { updateMake(it) },
            placeholder = {
                Text(stringResource(R.string.car_year))
            }

        )
        Spacer(modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = car.color,
            onValueChange = { updateMake(it) },
            placeholder = {
                Text(stringResource(R.string.car_color))
            }

        )

        Button(onClick = { updateCar(car) }) {
            Text(text = stringResource(R.string.update))
        }
    }
}
