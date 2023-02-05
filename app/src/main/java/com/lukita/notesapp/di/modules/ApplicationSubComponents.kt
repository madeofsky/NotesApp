package com.lukita.notesapp.di.modules

import com.lukita.notesapp.login.di.component.NotesLoginComponent
import dagger.Module

@Module(subcomponents = [NotesLoginComponent::class])
interface ApplicationSubComponents