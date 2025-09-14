package com.ojasx.FinTrack.Budgets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class BudgetCard(
    val  name : String,
    val amount : Int,
    val period : String
    )

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

    fun updatePeriod(newPeriod: String) {
        _period.value = newPeriod
    }

    // dynamic list of cards

    private val _budgets = MutableLiveData<List<BudgetCard>>(emptyList())
    val budgets : LiveData<List<BudgetCard>> = _budgets

    fun saveBudget(){
        val newBudget = BudgetCard(
            name = _name.value ?: "",
            amount = _amount.value ?: 0,
            period = _period.value ?: ""
        )
        val updatedList = _budgets.value?.toMutableList() ?: mutableListOf()
        updatedList.add(newBudget)
        _budgets.value = updatedList
    }
}
