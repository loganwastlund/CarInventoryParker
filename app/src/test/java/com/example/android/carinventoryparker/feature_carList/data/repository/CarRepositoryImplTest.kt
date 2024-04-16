package com.example.android.carinventoryparker.feature_carList.data.repository

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
class CarRepositoryImplTest {

    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: CarDatabase
    private lateinit var dao: CarDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            CarDatabase::class.java,
        ).allowMainThreadQueries().build()

        dao = database.carDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun addCarToRoom() = runTest {
        val car = Car(
            id = 1979,
            make = "Toyota",
            model = "Tacoma",
            year = "1999",
            color = "Silver"
        )

        dao.addCar(car)
        val retrievedCar = dao.getCar(1979)

        assertThat(retrievedCar).isEqualTo(car)
    }
}