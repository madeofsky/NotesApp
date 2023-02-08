package com.lukita.notesapp.home.presentation

import androidx.lifecycle.ViewModel
import com.lukita.notesapp.appenter.domain.FirebaseAuthUseCase
import javax.inject.Inject

class NotesHomeViewModel @Inject constructor(
    private val firebaseAuthUseCase: FirebaseAuthUseCase
) : ViewModel() {

    fun onLogoutClick() {
        firebaseAuthUseCase.logOutUser()
    }
}