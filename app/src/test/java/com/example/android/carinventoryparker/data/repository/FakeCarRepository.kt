package com.example.android.carinventoryparker.data.repository

import com.example.android.carinventoryparker.feature_carList.domain.model.Car
import com.example.android.carinventoryparker.feature_carList.domain.repository.CarRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeCarRepository : CarRepository {
    private val cars = mutableListOf<Car>()

    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value: Boolean) {
        shouldReturnNetworkError = value
    }

    override fun addCarToRoom(car: Car) {
        cars.add(car)
    }

    override fun getAllCarsFromRoom(): Flow<List<Car>> = flow {
        try {
            emit(cars)
        } catch (e: Exception) {
            println(e.message)
        }
    }

    override fun getOneCar(id: Int): Flow<Car> = flow {
        try {
            val carWithId = cars.find { it.id == id }
            if (carWithId != null) {
                emit(carWithId)
            } else {
                throw NoSuchElementException("Car with ID $id not found")
            }
        } catch (e: Exception) {
            println(e.message)
        }
    }

    override fun updateCarInRoom(car: Car) {
        try {
            val foundCar = cars.find { it.id == car.id }
            if (foundCar != null) {
                cars.remove(foundCar)
            } else {
                throw IllegalStateException("Attempt to update a car that doesn't exist in the repository.")
            }
            cars.add(car)
        } catch (e: Error) {
            println(e.message)
        }
    }

    override fun deleteCarInRoom(car: Car) {
        try {
            cars.remove(car)
        } catch (e: Exception) {
            println(e.message)
        }
    }
}
