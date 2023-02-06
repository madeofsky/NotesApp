package com.lukita.notesapp.appenter.login.di

import com.lukita.notesapp.appenter.login.ui.NotesLoginFragment
import dagger.Subcomponent

@Subcomponent
interface NotesLoginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NotesLoginComponent
    }

    fun inject(fragment: NotesLoginFragment)
}