package com.ojasx.wallet_clone.CalculatorWorking.CalculatorScreen.Category.CardComposable.SubCategoryCards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _selectedTitle = MutableLiveData("Select a Card")
    val selectedTitle: LiveData<String> = _selectedTitle

    fun updateSelectedTitle(title: String) {
        _selectedTitle.value = title
    }
}
