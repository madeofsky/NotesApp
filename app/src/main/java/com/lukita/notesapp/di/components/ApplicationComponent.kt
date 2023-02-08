package com.lukita.notesapp.di.components

import android.content.Context
import com.lukita.notesapp.NotesApplication
import com.lukita.notesapp.appenter.di.component.NotesAppEnterActivityComponent
import com.lukita.notesapp.appenter.di.module.FirebaseModule
import com.lukita.notesapp.di.modules.ApplicationSubComponents
import com.lukita.notesapp.home.di.NotesHomeActivityComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationSubComponents::class, FirebaseModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    fun inject(application: NotesApplication)
    fun notesAppEnterComponent(): NotesAppEnterActivityComponent.Factory
    fun notesHomeComponent(): NotesHomeActivityComponent.Factory

}