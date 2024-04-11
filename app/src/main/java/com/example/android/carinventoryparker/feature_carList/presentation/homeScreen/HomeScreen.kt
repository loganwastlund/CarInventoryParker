package com.example.android.carinventoryparker.feature_carList.presentation.homeScreen

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.android.carinventoryparker.feature_carList.presentation.destinations.UpdateCarScreenDestination
import com.example.android.carinventoryparker.feature_carList.presentation.homeScreen.subViews.AddCarDialog
import com.example.android.carinventoryparker.feature_carList.presentation.homeScreen.subViews.CarsList
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getAllCars()
    }
    val cars by viewModel.cars.collectAsStateWithLifecycle()

    Scaffold(
        floatingActionButton = {
            CarFAB {
                viewModel.toggleDialog()
            }
        }
    ) {
        CarsList(
            listOfCars = cars,
            deleteCar = { viewModel.deleteCar(it) },
            navigateToUpdate = { navigator.navigate(UpdateCarScreenDestination(it.id)) }
        )
        AddCarDialog(
            isDialogOpen = viewModel.isDialogOpen,
            closeDialog = { viewModel.toggleDialog() }
        ) {
            viewModel.addCar(it)
        }
    }
}
