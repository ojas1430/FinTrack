package com.ojasx.FinTrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModelProvider
import com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.CalculatorViewModel
import com.ojasx.FinTrack.Navigation.Navigation
import com.ojasx.FinTrack.Records.RecordsViewModel
import com.ojasx.FinTrack.Statistics.StatisticsMainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val CalculatorViewModel = ViewModelProvider(this)[CalculatorViewModel :: class.java]
        enableEdgeToEdge()
        setContent {
           Navigation()
        }
    }
}

