package com.example.android.carinventoryparker.views.homeScreen

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.android.carinventoryparker.views.homeScreen.subViews.AddCarDialog
import com.example.android.carinventoryparker.views.homeScreen.subViews.CarsList
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
            navigateToUpdate = {}
        )
        AddCarDialog(
            isDialogOpen = viewModel.isDialogOpen,
            closeDialog = { viewModel.toggleDialog() }
        ) {
            viewModel.addCar(it)
        }
    }
}
