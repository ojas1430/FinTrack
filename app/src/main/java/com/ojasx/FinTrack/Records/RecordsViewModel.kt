package com.ojasx.FinTrack.Records

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ojasx.FinTrack.Statistics.Balance.BalancePoint
import java.time.LocalDate

class RecordsViewModel : ViewModel() {

    private val _recordList = MutableLiveData<List<RecordsDataClass>>(emptyList())
    val recordlist: LiveData<List<RecordsDataClass>> get() = _recordList

    // ---- Category selection handling ----
    private val _selectedTitle = MutableLiveData("Select Category")
    val selectedTitle: LiveData<String> = _selectedTitle

    private val _selectedIcon = MutableLiveData<RecordIcons?>()
    val selectedIcon: LiveData<RecordIcons?> = _selectedIcon

    // ---- Totals ----
    fun getTotal(): Int {
        return _recordList.value?.sumOf { it.amount.toIntOrNull() ?: 0 } ?: 0
    }

    fun getIncomeTotal(): Int {
        return _recordList.value
            ?.filter { (it.amount.toIntOrNull() ?: 0) > 0 }
            ?.sumOf { it.amount.toIntOrNull() ?: 0 } ?: 0
    }

    fun getTotalExpense(): Int {
        return _recordList.value
            ?.filter { (it.amount.toIntOrNull() ?: 0) < 0 }
            ?.sumOf { it.amount.toIntOrNull() ?: 0 } ?: 0
    }

    // ---- Add / Delete Records ----
    fun addRecord(title: String, amount: String, date: String, icon: RecordIcons) {
        val current = _recordList.value.orEmpty()
        val newRecord = RecordsDataClass(
            id = current.size + 1,
            title = title,
            amount = amount,
            icon = icon,
            date = date
        )
        _recordList.value = current + newRecord
        updateBalanceHistory()
    }

    fun deleteRecord(id: Int) {
        _recordList.value = _recordList.value?.filterNot { it.id == id }
        updateBalanceHistory()
    }

    fun selectCategory(title: String, icon: RecordIcons) {
        _selectedTitle.value = title
        _selectedIcon.value = icon
    }

    // ---- Graph Data ----
    private val _balanceHistory = MutableLiveData<List<BalancePoint>>(emptyList())
    val balanceHistory: LiveData<List<BalancePoint>> get() = _balanceHistory

    private fun updateBalanceHistory() {
        val newTotal = getTotal()
        val today = LocalDate.now()
        val current = _balanceHistory.value.orEmpty()
        val updated = current.filterNot { it.date == today } + BalancePoint(today, newTotal)
        _balanceHistory.value = updated
    }
}
