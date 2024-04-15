package com.example.android.carinventoryparker.feature_carList.presentation.updateScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.android.carinventoryparker.R
import com.example.android.carinventoryparker.feature_carList.presentation.updateScreen.subviews.UpdateCarContent
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun UpdateCarScreen(
    navigator: DestinationsNavigator,
    viewModel: UpdateScreenViewModel = hiltViewModel(),
    carID: Int,
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.getOneCar(carID)
    }

    val selectedCar by viewModel.selectedCar.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.update_car_screen))
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navigator.navigateUp()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBackIosNew,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                }
            )
        }
    ) {
        UpdateCarContent(
            paddingValues = it,
            car = selectedCar,
            updateMake = { make -> viewModel.updateMake(make) },
            updateModel = { model -> viewModel.updateModel(model) },
            updateYear = { year -> viewModel.updateYear(year) },
            updateColor = { color -> viewModel.updateColor(color) },
            updateCar = { car ->
                viewModel.updateCarInRoom(car)
                navigator.navigateUp()
//                 TODO: What did i miss?
            }
        )
    }
}
