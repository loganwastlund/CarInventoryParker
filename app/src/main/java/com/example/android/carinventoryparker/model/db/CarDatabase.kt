package com.example.android.carinventoryparker.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android.carinventoryparker.model.dao.CarDao
import com.example.android.carinventoryparker.model.entity.Car

const val CAR_DATABASE = "car_database"

@Database(entities = [Car::class], version = 1, exportSchema = true)
abstract class CarDatabase : RoomDatabase() {
    abstract fun carDao(): CarDao
}
