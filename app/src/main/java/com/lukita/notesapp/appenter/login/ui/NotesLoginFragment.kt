package com.lukita.notesapp.appenter.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.lukita.notesapp.appenter.NotesAppEnterActivity
import com.lukita.notesapp.databinding.FragmentNotesLoginBinding
import com.lukita.notesapp.appenter.login.data.User
import com.lukita.notesapp.appenter.login.presentation.NotesLoginViewModel
import javax.inject.Inject

class NotesLoginFragment : Fragment() {

    private lateinit var binding: FragmentNotesLoginBinding

    @Inject
    lateinit var viewModel: NotesLoginViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        (requireActivity() as NotesAppEnterActivity).activityComponent.notesLoginComponent().create().inject(this)
        binding = FragmentNotesLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewCreated()
        initViews()
        initViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    private fun initViews() {
        binding.layoutLoginCard.textViewForgotMyPassword.setOnClickListener {
            viewModel.onForgotPasswordClick()
        }
        binding.layoutLoginCard.buttonLogin.setOnClickListener {
            val username = binding.layoutLoginCard.editTextUsername.toString()
            val password = binding.layoutLoginCard.editTextPassword.toString()

            if (username.isNotBlank() && password.isNotBlank()) viewModel.onLoginClick(User(username, password))
            else Toast.makeText(context, "Please, fill with your information to Login!", Toast.LENGTH_SHORT).show()
        }
        binding.layoutLoginCard.textViewSingUp.setOnClickListener {
            viewModel.onSingUpClick()
        }
    }

    private fun initViewModel() {

    }

}