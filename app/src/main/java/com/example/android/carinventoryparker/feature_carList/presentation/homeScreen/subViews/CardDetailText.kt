package com.example.android.carinventoryparker.feature_carList.presentation.homeScreen.subViews

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun CarDetailText(
    carDetails: String,
    fontSize: Int = 24
) {
    Text(
        text = carDetails,
        fontSize = fontSize.sp
    )
}
