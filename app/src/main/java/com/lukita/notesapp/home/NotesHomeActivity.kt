package com.lukita.notesapp.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lukita.notesapp.databinding.ActivityNotesHomeBinding

class NotesHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotesHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}