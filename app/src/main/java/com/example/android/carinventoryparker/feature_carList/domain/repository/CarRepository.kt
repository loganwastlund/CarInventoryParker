package com.example.android.carinventoryparker.feature_carList.domain.repository

import com.example.android.carinventoryparker.feature_carList.domain.model.Car
import kotlinx.coroutines.flow.Flow

interface CarRepository {
    fun addCarToRoom(car: Car)

    fun getAllCarsFromRoom(): Flow<List<Car>>

    fun getOneCar(id: Int): Flow<Car>

    fun updateCarInRoom(car: Car)

    fun deleteCarInRoom(car: Car)
}
