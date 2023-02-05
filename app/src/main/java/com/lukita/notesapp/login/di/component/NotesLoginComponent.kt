package com.lukita.notesapp.login.di.component

import com.lukita.notesapp.login.di.module.NotesLoginModule
import com.lukita.notesapp.login.presentation.NotesLoginViewModel
import com.lukita.notesapp.login.ui.NotesLoginActivity
import com.lukita.notesapp.login.ui.NotesLoginFragment
import dagger.Subcomponent

@Subcomponent(modules = [NotesLoginModule::class])
interface NotesLoginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NotesLoginComponent
    }

    fun inject(activity: NotesLoginActivity)
    fun inject(fragment: NotesLoginFragment)
}