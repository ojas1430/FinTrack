package com.ojasx.FinTrack.CalculatorWorking.CalculatorScreen.Category.CardComposable.SubCategoryCards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ojasx.FinTrack.Records.RecordIcons

class MainViewModel : ViewModel() {

    private val _selectedTitle = MutableLiveData("Select a Card")
    val selectedTitle: LiveData<String> = _selectedTitle

    private val _selectedIcon = MutableLiveData<RecordIcons?>()
    val selectedIcon: LiveData<RecordIcons?> = _selectedIcon

    fun updateSelectedIcon( icon: RecordIcons) {
        _selectedIcon.value = icon
    }
    fun updateSelectedTitle(title: String) {
        _selectedTitle.value = title
    }
}
