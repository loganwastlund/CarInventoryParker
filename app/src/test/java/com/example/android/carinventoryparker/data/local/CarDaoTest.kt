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
            make = "adipisci",
            model = "vitae",
            year = "sonet",
            color = "prompta"
        )
        dao.addCar(car)
        val retrievedCar = dao.getCar(2741)
        assertThat(retrievedCar).isEqualTo(car)
    }
}
