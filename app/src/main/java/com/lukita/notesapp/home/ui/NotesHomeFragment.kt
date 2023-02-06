package com.lukita.notesapp.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lukita.notesapp.R
import com.lukita.notesapp.home.presentation.NotesHomeViewModel
import javax.inject.Inject

class NotesHomeFragment : Fragment() {

    @Inject
    lateinit var viewModel: NotesHomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes_home, container, false)
    }
}