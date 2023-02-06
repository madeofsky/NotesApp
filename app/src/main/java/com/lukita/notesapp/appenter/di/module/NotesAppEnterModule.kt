package com.lukita.notesapp.appenter.di.module

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides

@Module
class NotesAppEnterModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
}