package com.lukita.notesapp.appenter.di.component

import com.lukita.notesapp.appenter.NotesAppEnterActivity
import com.lukita.notesapp.appenter.di.module.NotesAppEnterModule
import com.lukita.notesapp.appenter.login.di.NotesLoginComponent
import com.lukita.notesapp.appenter.login.ui.NotesLoginFragment
import com.lukita.notesapp.appenter.registration.di.NotesRegistrationComponent
import com.lukita.notesapp.appenter.registration.ui.NotesRegistrationFragment
import dagger.Subcomponent


@Subcomponent(modules = [NotesAppEnterModule::class])
interface NotesAppEnterComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NotesAppEnterComponent
    }

    fun inject(activity: NotesAppEnterActivity)
    fun notesLoginComponent(): NotesLoginComponent.Factory
    fun notesRegistrationComponent(): NotesRegistrationComponent.Factory
}