package com.lukita.notesapp.appenter.registration.di

import com.lukita.notesapp.appenter.registration.ui.NotesRegistrationFragment
import dagger.Subcomponent

@Subcomponent
interface NotesRegistrationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NotesRegistrationComponent
    }

    fun inject(fragment: NotesRegistrationFragment)
}