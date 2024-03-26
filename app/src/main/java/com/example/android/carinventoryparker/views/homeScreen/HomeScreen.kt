package com.example.android.carinventoryparker.views.homeScreen

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.android.carinventoryparker.views.homeScreen.subViews.AddCarDialog
import com.example.android.carinventoryparker.views.homeScreen.subViews.CarFAB
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    Scaffold(
        floatingActionButton = {
            CarFAB {
                viewModel.toggleDialog()
            }
        }
    ) {
        AddCarDialog(
            isDialogOpen = viewModel.isDialogOpen,
            closeDialog = { viewModel.toggleDialog() }
        )
    }
}
