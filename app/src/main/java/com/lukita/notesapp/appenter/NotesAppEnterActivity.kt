package com.lukita.notesapp.appenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lukita.notesapp.NotesApplication
import com.lukita.notesapp.R
import com.lukita.notesapp.appenter.di.component.NotesAppEnterActivityComponent
import com.lukita.notesapp.appenter.login.ui.NotesLoginFragment
import com.lukita.notesapp.databinding.ActivityNotesAppLoginBinding

class NotesAppEnterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotesAppLoginBinding

    val activityComponent: NotesAppEnterActivityComponent by lazy {
        (application as NotesApplication).appComponent.notesAppEnterComponent().create()
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