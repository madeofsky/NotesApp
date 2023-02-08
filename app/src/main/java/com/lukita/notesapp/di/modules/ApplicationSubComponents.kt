package com.lukita.notesapp.di.modules

import com.lukita.notesapp.appenter.di.component.NotesAppEnterActivityComponent
import com.lukita.notesapp.home.di.NotesHomeActivityComponent
import dagger.Module

@Module(
    subcomponents = [
        NotesAppEnterActivityComponent::class,
        NotesHomeActivityComponent::class
    ]
)
interface ApplicationSubComponents