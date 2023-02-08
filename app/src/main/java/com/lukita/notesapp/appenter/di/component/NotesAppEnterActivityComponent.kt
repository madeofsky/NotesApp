package com.lukita.notesapp.appenter.di.component

import com.lukita.notesapp.appenter.NotesAppEnterActivity
import com.lukita.notesapp.appenter.login.di.NotesLoginComponent
import com.lukita.notesapp.appenter.registration.di.NotesRegistrationComponent
import dagger.Subcomponent


@Subcomponent
interface NotesAppEnterActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NotesAppEnterActivityComponent
    }

    fun inject(activity: NotesAppEnterActivity)
    fun notesLoginComponent(): NotesLoginComponent.Factory
    fun notesRegistrationComponent(): NotesRegistrationComponent.Factory
}