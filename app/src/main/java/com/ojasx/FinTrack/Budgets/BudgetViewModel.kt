package com.ojasx.FinTrack.Budgets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BudgetViewModel : ViewModel() {
    private val _name = MutableLiveData("My Budget")
    val name: LiveData<String> = _name

    private val _amount = MutableLiveData(90000)
    val amount: LiveData<Int> = _amount

    private val _period = MutableLiveData("Week")
    val period: LiveData<String> = _period

    fun updateName(newName: String) {
        _name.value = newName
    }

    fun updateAmount(newAmount: Int) {
        _amount.value = newAmount
    }

    fun updatePeriod(newPeriod: String) {  // <-- Renamed properly
        _period.value = newPeriod
    }
}
