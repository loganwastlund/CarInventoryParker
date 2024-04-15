package com.example.android.carinventoryparker.feature_carList.presentation.updateScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.carinventoryparker.feature_carList.data.repository.CarRepositoryImpl
import com.example.android.carinventoryparker.feature_carList.domain.model.Car
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateScreenViewModel @Inject constructor(
    private val repository: CarRepositoryImpl
) : ViewModel() {

    private val _selectedCar = MutableStateFlow<Car>(Car(0, "", "", "", ""))
    val selectedCar = _selectedCar.asStateFlow()

    fun getOneCar(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getOneCar(id)
                .collect {
                    _selectedCar.value = it
                }
        }
    }

    fun updateCarInRoom(car: Car) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCarInRoom(car)
        }
    }

    fun updateMake(make: String) {
        _selectedCar.value = _selectedCar.value.copy(make = make)
    }
    fun updateModel(model: String) {
        _selectedCar.value = _selectedCar.value.copy(model = model)
    }
    fun updateYear(year: String) {
        _selectedCar.value = _selectedCar.value.copy(year = year)
    }
    fun updateColor(color: String) {
        _selectedCar.value = _selectedCar.value.copy(color = color)
    }
}
