package com.example.android.carinventoryparker.views.homeScreen.subViews

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.android.carinventoryparker.model.entity.Car

@Composable
fun CarsList(
    listOfCars: List<Car>,
    deleteCar: (Car) -> Unit,
    navigateToUpdate: (Car) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(listOfCars) {
            CarCard(car = it, deleteCar = { deleteCar(it) }) {
                navigateToUpdate(it)
            }
        }
    }
}
