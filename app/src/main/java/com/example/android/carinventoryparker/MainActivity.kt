package com.example.android.carinventoryparker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.android.carinventoryparker.ui.theme.CarInventoryParkerTheme
import com.example.android.carinventoryparker.views.homeScreen.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarInventoryParkerTheme {
                // A surface container using the 'background' color from the theme
                DestinationsNavHost(
                    navGraph = NavGraphs.root
                )
            }
        }
    }
}
