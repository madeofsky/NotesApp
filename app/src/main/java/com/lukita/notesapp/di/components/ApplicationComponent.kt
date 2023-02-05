package com.lukita.notesapp.di.components

import android.content.Context
import com.lukita.notesapp.NotesApplication
import com.lukita.notesapp.di.modules.ApplicationSubComponents
import com.lukita.notesapp.login.di.component.NotesLoginComponent
import com.lukita.notesapp.login.ui.NotesLoginActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationSubComponents::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun inject(application: NotesApplication)
    fun notesLoginComponent(): NotesLoginComponent.Factory

}