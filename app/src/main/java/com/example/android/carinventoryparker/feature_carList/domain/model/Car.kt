package com.example.android.carinventoryparker.feature_carList.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

const val CAR_TABLE = "car_table"

@Serializable
@Entity(tableName = CAR_TABLE)
data class Car(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val make: String,
    val model: String,
    val year: String,
    val color: String,
)
