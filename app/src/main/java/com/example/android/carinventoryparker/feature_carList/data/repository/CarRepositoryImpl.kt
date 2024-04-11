package com.example.android.carinventoryparker.feature_carList.data.repository

import com.example.android.carinventoryparker.feature_carList.data.local.CarDatabase
import com.example.android.carinventoryparker.feature_carList.domain.model.Car
import com.example.android.carinventoryparker.feature_carList.domain.repository.CarRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    private val database: CarDatabase
) : CarRepository {
    override fun addCarToRoom(car: Car) {
        database.carDao().addCar(car)
    }

    override fun getAllCarsFromRoom(): Flow<List<Car>> = flow {
        try {
            val cars = database.carDao().getAllCars()
            if (cars.isNotEmpty()) {
                emit(cars)
            }
        } catch (e: Exception) {
            println(e.message)
        }
    }.flowOn(Dispatchers.IO)

    override fun getOneCar(id: Int): Flow<Car> = flow {
        try {
            emit(database.carDao().getCar(id))
        } catch (e: Exception) {
            println(e.message)
        }
    }.flowOn(Dispatchers.IO)

    override fun updateCarInRoom(car: Car) {
        try {
            database.carDao().updateCar(car)
        } catch (e: Exception) {
            println(e.message)
        }
    }

    override fun deleteCarInRoom(car: Car) {
        try {
            database.carDao().deleteCar(car)
        } catch (e: Exception) {
            println(e.message)
        }
    }
}
