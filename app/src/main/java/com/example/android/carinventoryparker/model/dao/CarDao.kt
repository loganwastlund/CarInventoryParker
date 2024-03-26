package com.example.android.carinventoryparker.model.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.android.carinventoryparker.model.entity.CAR_TABLE
import com.example.android.carinventoryparker.model.entity.Car

@Dao
interface CarDao {
    // Create
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCar(car: Car)

    // Read/Retrieve
    @Query("SELECT * FROM $CAR_TABLE ORDER BY year ASC")
    suspend fun getAllCars(): List<Car>

    @Query("SELECT * FROM $CAR_TABLE WHERE id = :id")
    suspend fun getCar(id: Int): Car

    // Update
    @Update
    fun updateCar(car: Car)

    // Delete
    @Delete
    fun deleteCar(car: Car)
}
