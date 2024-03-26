package com.example.android.carinventoryparker.model.repository

import com.example.android.carinventoryparker.model.entity.Car
import kotlinx.coroutines.flow.Flow

interface CarRepository {
    fun addCarToRoom(car: Car)

    fun getAllCarsFromRoom(): Flow<List<Car>>

    fun getOneCar(id: Int): Flow<Car>

    fun updateCarInRoom(car: Car)

    fun deleteCarInRoom(car: Car)
}
