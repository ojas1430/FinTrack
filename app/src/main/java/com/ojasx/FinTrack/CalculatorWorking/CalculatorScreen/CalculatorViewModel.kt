package com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable


class CalculatorViewModel : ViewModel() {

    // the above calculator equation live data code
    private val _equationText = MutableLiveData("")
    val equationText : LiveData<String> = _equationText

    // Result Calculator live data code
    private val _resultdata = MutableLiveData("0")
    val resultdata : LiveData<String> = _resultdata


    //to update live category
    var selectedCategory by mutableStateOf("ELECTRONICS")
        private set

    fun updateCategory(newCategory: String) {
        selectedCategory = newCategory
    }


    fun onButtonClick(btn : String){

        // this below line checks if its not null then execute
        _equationText.value?.let {

            if(btn == "AC"){
                _equationText.value = ""
                _resultdata.value = "0"
                return
            }

            if(btn == "C" ){
                if(it.isNotEmpty()){
                    _equationText.value = it.substring(0,it.length-1)
                    return
                }
            }

            if (btn == "=") {
                try {
                    _resultdata.value = CalculateResult(_equationText.value ?: "")
                } catch (_: Exception) {
                    // Ignoring exceptions to prevent app crash on invalid input
                }
                return
            }


            // concatinate numbers and symbols
            _equationText.value = it + btn

            // Live calculate result as you type
            try {
                _resultdata.value = CalculateResult(_equationText.value ?: "")
            } catch (_: Exception) { }

        }

    }

    fun CalculateResult(equation: String): String {
        if (equation.isEmpty()) return "0"

        val context: Context = Context.enter()
        try {
            context.optimizationLevel = -1
            val scriptable: Scriptable = context.initStandardObjects()
            val finalresult = context.evaluateString(scriptable, equation, "JavaScript", 1, null)

            // Convert the result to string properly
            val resultString = when (finalresult) {
                is Number -> finalresult.toString()
                is String -> finalresult
                else -> finalresult.toString()
            }

            // Remove .0 from the end if present
            return if (resultString.endsWith(".0")) {
                resultString.substring(0, resultString.length - 2)
            } else {
                resultString
            }
        } finally {
            // Always exit the context to prevent memory leaks
            Context.exit()
        }
    }
}


