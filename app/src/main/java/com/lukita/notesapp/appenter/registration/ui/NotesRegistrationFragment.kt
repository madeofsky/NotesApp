package com.lukita.notesapp.appenter.registration.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lukita.notesapp.appenter.NotesAppEnterActivity
import com.lukita.notesapp.databinding.FragmentNotesRegistrationBinding
import javax.inject.Inject

class NotesRegistrationFragment : Fragment() {

    @Inject
    lateinit var viewModel: NotesRegistrationViewModel

    private lateinit var binding: FragmentNotesRegistrationBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        (requireActivity() as NotesAppEnterActivity).activityComponent.notesRegistrationComponent().create().inject(this)
        binding = FragmentNotesRegistrationBinding.inflate(layoutInflater)
        return binding.root
    }

}