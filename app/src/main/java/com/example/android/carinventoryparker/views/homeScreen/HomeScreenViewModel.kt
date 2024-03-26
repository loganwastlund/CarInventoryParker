package com.example.android.carinventoryparker.views.homeScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.android.carinventoryparker.model.repository.CarRepository
import com.example.android.carinventoryparker.model.repository.CarRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: CarRepositoryImpl,
) : ViewModel() {
    var isDialogOpen by mutableStateOf(false)

    fun toggleDialog() {
        isDialogOpen = !isDialogOpen
    }
}
