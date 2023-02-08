package com.lukita.notesapp.home.di

import com.lukita.notesapp.home.NotesHomeActivity
import dagger.Subcomponent

@Subcomponent
interface NotesHomeActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NotesHomeActivityComponent
    }

    fun inject(activity: NotesHomeActivity)
//    fun notesHomeFragmentComponent(): NotesHomeFragmentComponent.Factory
}