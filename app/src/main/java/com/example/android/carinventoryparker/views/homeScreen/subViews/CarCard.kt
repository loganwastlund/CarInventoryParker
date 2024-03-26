package com.example.android.carinventoryparker.views.homeScreen.subViews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DeleteForever
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.android.carinventoryparker.R
import com.example.android.carinventoryparker.model.entity.Car

@Composable
fun CarCard(
    car: Car,
    deleteCar: () -> Unit,
    navigate: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        onClick = { navigate() }

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                CarDetailText(carDetails = car.model, fontSize = 36)
                CarDetailText(carDetails = car.make)
                CarDetailText(carDetails = car.year)
                CarDetailText(carDetails = car.color)
            }

            Spacer(modifier = Modifier.weight(1f))

            IconButton(onClick = { deleteCar() }) {
                Icon(
                    imageVector = Icons.Rounded.DeleteForever,
                    contentDescription = stringResource(R.string.delete_car)
                )
            }
        }
    }
}
