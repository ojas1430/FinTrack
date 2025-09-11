package com.ojasx.FinTrack.SideBar.UserProfile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _firstName = MutableLiveData("Ojas")
    val firstName: LiveData<String> = _firstName

    private val _lastName = MutableLiveData("Choudhary")
    val lastName: LiveData<String> = _lastName

    private val _email = MutableLiveData("ojas@email.com")
    val email: LiveData<String> = _email

    fun updateProfile(first: String, last: String, mail: String) {
        _firstName.value = first
        _lastName.value = last
        _email.value = mail
    }
}
