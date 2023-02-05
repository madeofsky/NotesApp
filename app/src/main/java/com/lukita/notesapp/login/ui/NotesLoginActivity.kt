package com.lukita.notesapp.login.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lukita.notesapp.NotesApplication
import com.lukita.notesapp.R
import com.lukita.notesapp.databinding.ActivityNotesAppLoginBinding
import com.lukita.notesapp.di.components.ApplicationComponent
import com.lukita.notesapp.login.di.component.NotesLoginComponent

class NotesLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotesAppLoginBinding

    val activityComponent: NotesLoginComponent by lazy {
        (application as NotesApplication).appComponent.notesLoginComponent().create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent.inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivityNotesAppLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, NotesLoginFragment())
                .commitNow()
        }
    }
}