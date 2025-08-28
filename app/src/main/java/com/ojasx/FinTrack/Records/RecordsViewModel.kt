package com.ojasx.FinTrack.Records

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecordsViewModel : ViewModel() {

    private val _recordList = MutableLiveData<List<RecordsDataClass>>(emptyList())
    val recordlist: LiveData<List<RecordsDataClass>> get() = _recordList

    // ---- Category selection handling ----
    private val _selectedTitle = MutableLiveData("Select Category")
    val selectedTitle: LiveData<String> = _selectedTitle

    private val _selectedIcon = MutableLiveData<RecordIcons?>()
    val selectedIcon: LiveData<RecordIcons?> = _selectedIcon

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
    }

    fun deleteRecord(id: Int) {
        _recordList.value = _recordList.value?.filterNot { it.id == id }
    }

    fun selectCategory(title: String, icon: RecordIcons) {
        _selectedTitle.value = title
        _selectedIcon.value = icon
    }
}
