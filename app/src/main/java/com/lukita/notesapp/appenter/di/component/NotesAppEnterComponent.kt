package com.lukita.notesapp.appenter.di.component

import com.lukita.notesapp.appenter.NotesAppEnterActivity
import com.lukita.notesapp.appenter.di.module.NotesAppEnterModule
import com.lukita.notesapp.appenter.login.ui.NotesLoginFragment
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

@Subcomponent
interface NotesLoginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NotesLoginComponent
    }

    fun inject(fragment: NotesLoginFragment)
}

@Subcomponent
interface NotesRegistrationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NotesRegistrationComponent
    }

    fun inject(fragment: NotesRegistrationFragment)
}