package com.ojasx.FinTrack.Debts.LentForm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class LentCard(
    val  name : String,
    val description : String,
    val amount : Int,
    val period : String
)

class LentViewModel : ViewModel() {
    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    private val _description = MutableLiveData("")
    val description: LiveData<String> = _description

    private val _account = MutableLiveData("Week")
    val account: LiveData<String> = _account

    private val _amount = MutableLiveData(90000)
    val amount: LiveData<Int> = _amount

    fun updateName(newName: String) {
        _name.value = newName
    }

    fun updateDescription(newDescription: String) {
        _description.value = newDescription
    }

    fun updateAmount(newAmount: Int) {
        _amount.value = newAmount
    }

    fun updateAccount(newAccount: String) {
        _account.value = newAccount
    }

    // dynamic list of cards

    private val _budgets = MutableLiveData<List<LentCard>>(emptyList())
    val budgets : LiveData<List<LentCard>> = _budgets

    fun saveBudget(){
        val newBudget = LentCard(
            name = _name.value ?: "",
            description = _description.value?: "",
            amount = _amount.value ?: 0,
            period = _account.value ?: ""
        )
        val updatedList = _budgets.value?.toMutableList() ?: mutableListOf()
        updatedList.add(newBudget)
        _budgets.value = updatedList
    }
}
