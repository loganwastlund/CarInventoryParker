package com.example.android.carinventoryparker.feature_carList.presentation.homeScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.carinventoryparker.feature_carList.domain.model.Car
import com.example.android.carinventoryparker.feature_carList.data.repository.CarRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: CarRepositoryImpl,
) : ViewModel() {
    var isDialogOpen by mutableStateOf(false)

    private val _cars = MutableStateFlow<List<Car>>(emptyList())
    val cars = _cars.asStateFlow()

    fun getAllCars() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllCarsFromRoom()
                .collect {
                    _cars.value = it
                }
        }
    }

    fun addCar(car: Car) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCarToRoom(car)
            getAllCars()
        }
    }

    fun deleteCar(car: Car) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCarInRoom(car)
            getAllCars()
        }
    }

    fun toggleDialog() {
        isDialogOpen = !isDialogOpen
    }
}
