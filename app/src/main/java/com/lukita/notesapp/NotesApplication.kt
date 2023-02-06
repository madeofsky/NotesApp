package com.lukita.notesapp

import android.app.Application
import com.google.firebase.FirebaseApp
import com.lukita.notesapp.di.components.ApplicationComponent
import com.lukita.notesapp.di.components.DaggerApplicationComponent

open class NotesApplication: Application() {

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        FirebaseApp.initializeApp(this)
    }
}