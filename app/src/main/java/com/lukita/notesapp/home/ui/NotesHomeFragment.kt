package com.lukita.notesapp.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lukita.notesapp.databinding.FragmentNotesHomeBinding
import com.lukita.notesapp.home.presentation.NotesHomeViewModel
import javax.inject.Inject

class NotesHomeFragment : Fragment() {

    private lateinit var binding: FragmentNotesHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentNotesHomeBinding.inflate(layoutInflater)
        return binding.root
    }
}