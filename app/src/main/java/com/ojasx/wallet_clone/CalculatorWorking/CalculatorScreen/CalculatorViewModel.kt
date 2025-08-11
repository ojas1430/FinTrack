package com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen

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
                    _equationText.value = it.substring(0,it.length)
                    return
                }
            }
            // concatinate numbers and symbols
            _equationText.value = it + btn

            //calculate result
            try {
               _resultdata.value =  CalculateResult(equationText.value.toString())
            }catch (_ : Exception){}

        }



    }
    fun CalculateResult(equation : String) : String {
        val context: Context = Context.enter()
        context.optimizationLevel = -1
        val scriptable : Scriptable = context.initStandardObjects()
       val finalresult =  context.evaluateString(scriptable,equation,"JavaScript",1,null)
       return finalresult as String
    }
}