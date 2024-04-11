package com.example.android.carinventoryparker.feature_carList.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android.carinventoryparker.feature_carList.domain.model.Car

const val CAR_DATABASE = "car_database"

@Database(entities = [Car::class], version = 1, exportSchema = true)
abstract class CarDatabase : RoomDatabase() {
    abstract fun carDao(): CarDao
}
