package com.lukita.notesapp.appenter.registration.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.lukita.notesapp.appenter.domain.FirebaseResult
import com.lukita.notesapp.appenter.domain.NotesLoginUseCase
import com.lukita.notesapp.appenter.registration.data.UserRegistrationInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class RegistrationEvents {
    class SendUserToLoginScreen(val user: FirebaseUser? = null): RegistrationEvents()
    object ShowErrorToast: RegistrationEvents()
}

class NotesRegistrationViewModel @Inject constructor(
    private val useCase: NotesLoginUseCase
) : ViewModel() {

    private val _registrationEvents = MutableLiveData<RegistrationEvents>()
    val registrationEvents: LiveData<RegistrationEvents> = _registrationEvents

    fun onRegisterClick(user: UserRegistrationInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = useCase.registerUserOnFirebase(user)) {
                is FirebaseResult.Failure -> _registrationEvents.postValue(RegistrationEvents.ShowErrorToast)
                is FirebaseResult.Success -> _registrationEvents.postValue(RegistrationEvents.SendUserToLoginScreen(result.data))
            }
        }
    }

    fun onSignInClick() {
        _registrationEvents.postValue(RegistrationEvents.SendUserToLoginScreen())
    }
}