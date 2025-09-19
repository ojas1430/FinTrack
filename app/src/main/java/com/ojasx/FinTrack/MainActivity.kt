package com.ojasx.FinTrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.CalculatorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val CalculatorViewModel = ViewModelProvider(this)[CalculatorViewModel :: class.java]
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}
