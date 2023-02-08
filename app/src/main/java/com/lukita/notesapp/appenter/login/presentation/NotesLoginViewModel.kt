package com.lukita.notesapp.appenter.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lukita.notesapp.appenter.domain.FirebaseResult
import com.lukita.notesapp.appenter.domain.FirebaseAuthUseCase
import com.lukita.notesapp.appenter.login.data.UserLoginInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class NotesLoginEvents {
    object SendUserToRegisterScreen : NotesLoginEvents()
    object ShowErrorToast : NotesLoginEvents()
    object SentUserToHomeScreen : NotesLoginEvents()
}

class NotesLoginViewModel @Inject constructor(
    private val useCase: FirebaseAuthUseCase
) : ViewModel() {

    private val _loginEvents = MutableLiveData<NotesLoginEvents>()
    val loginEvents: LiveData<NotesLoginEvents> get() = _loginEvents

    fun onForgotPasswordClick() {
    }

    fun onLoginClick(userLoginInfoInfo: UserLoginInfo) {
        viewModelScope.launch(Dispatchers.IO) {
            when (useCase.loginUser(userLoginInfoInfo.username, userLoginInfoInfo.password)) {
                is FirebaseResult.Failure -> _loginEvents.postValue(NotesLoginEvents.ShowErrorToast)
                is FirebaseResult.Success -> _loginEvents.postValue(NotesLoginEvents.SentUserToHomeScreen)
            }
        }
    }

    fun onSignUpClick() {
        _loginEvents.value = NotesLoginEvents.SendUserToRegisterScreen
    }
}