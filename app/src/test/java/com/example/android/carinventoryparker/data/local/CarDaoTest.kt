package com.example.android.carinventoryparker.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.android.carinventoryparker.feature_carList.data.local.CarDao
import com.example.android.carinventoryparker.feature_carList.data.local.CarDatabase
import com.example.android.carinventoryparker.feature_carList.domain.model.Car
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class CarDaoTest {
    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: CarDatabase
    private lateinit var dao: CarDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            CarDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.carDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun addCar() = runTest {
        val car = Car(
            id = 2741,
            make = "Toyota",
            model = "Tacoma",
            year = "2001",
            color = "Silver"
        )
        dao.addCar(car)
        val retrievedCar = dao.getCar(2741)

        assertThat(retrievedCar).isEqualTo(car)
    }

    @Test
    fun getAllCars() = runTest {
        val carsInserted = listOf(
            Car(
                id = 2726,
                make = "quaerendum",
                model = "penatibus",
                year = "molestie",
                color = "adolescens"
            ),
            Car(
                id = 2260,
                make = "explicari",
                model = "deterruisset",
                year = "persequeris",
                color = "electram"
            ),
            Car(
                id = 8353,
                make = "reprimique",
                model = "labores",
                year = "scripta",
                color = "iaculis"
            )
        )
        carsInserted.forEach { car ->
            dao.addCar(car)
        }
        val carsRetrieved = dao.getAllCars()

        assertThat(carsRetrieved).isEqualTo(carsInserted)
    }

    @Test
    fun getCar() = runTest {
        val carInserted = Car(
            id = 5267,
            make = "minim",
            model = "eloquentiam",
            year = "ultricies",
            color = "graeco"
        )
        dao.addCar(carInserted)
        val carRetrieved = dao.getCar(carInserted.id)

        assertThat(carRetrieved).isEqualTo(carInserted)
    }

    @Test
    fun updateCar() = runTest {
        val carInitial = Car(
            id = 7375,
            make = "postea",
            model = "solum",
            year = "pellentesque",
            color = "finibus"
        )
        dao.addCar(carInitial)

        val carEdited = carInitial.apply {
            make = "newMake"
            model = "newModel"
            year = "newYear"
            color = "newColor"
        }
        dao.updateCar(carEdited)
        val carRetrieved = dao.getCar(carEdited.id)

        assertThat(carRetrieved).isEqualTo(carEdited)
    }

    @Test
    fun deleteCar() = runTest {
        val car = Car(
            id = 2741,
            make = "Toyota",
            model = "Tacoma",
            year = "2001",
            color = "Silver"
        )
        dao.addCar(car)
        dao.deleteCar(car)
        val allCars = dao.getAllCars()

        assertThat(allCars).doesNotContain(car)
    }
}
