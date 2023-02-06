package com.lukita.notesapp.appenter.login.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.lukita.notesapp.R
import com.lukita.notesapp.appenter.NotesAppEnterActivity
import com.lukita.notesapp.appenter.login.data.UserLoginInfo
import com.lukita.notesapp.appenter.login.presentation.NotesLoginEvents
import com.lukita.notesapp.appenter.login.presentation.NotesLoginViewModel
import com.lukita.notesapp.appenter.registration.ui.NotesRegistrationFragment
import com.lukita.notesapp.databinding.FragmentNotesLoginBinding
import com.lukita.notesapp.home.NotesHomeActivity
import com.lukita.notesapp.utils.addFragment
import com.lukita.notesapp.utils.startActivity
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
        initViews()
        initViewModel()
    }

    private fun initViews() {
        val args = arguments?.getString(NotesRegistrationFragment.EMAIL)

        if (args != null) {
            binding.layoutLoginCard.editTextEmail.setText(args)
        }

        binding.layoutLoginCard.textViewForgotMyPassword.setOnClickListener {
            viewModel.onForgotPasswordClick()
        }
        binding.layoutLoginCard.buttonLogin.setOnClickListener {
            val email = binding.layoutLoginCard.editTextEmail.text.toString()
            val password = binding.layoutLoginCard.editTextPassword.text.toString()

            if (email.isNotBlank() && password.isNotBlank()) viewModel.onLoginClick(UserLoginInfo(email, password))
            else Toast.makeText(context, "Please, fill with your information to Login!", Toast.LENGTH_SHORT).show()
        }
        binding.layoutLoginCard.textViewSingUp.setOnClickListener {
            viewModel.onSignUpClick()
        }
    }

    private fun initViewModel() {
        viewModel.loginEvents.observe(viewLifecycleOwner) { events ->
            when (events) {
                NotesLoginEvents.SendUserToRegisterScreen -> {
                    activity?.supportFragmentManager?.addFragment(R.id.container, NotesRegistrationFragment())
                }
                NotesLoginEvents.SentUserToHomeScreen -> requireContext().startActivity(
                    NotesHomeActivity::class.java, Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                NotesLoginEvents.ShowErrorToast -> Toast.makeText(requireContext(), "Server Error", Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {
        fun newInstance(emailParam: String?) = NotesLoginFragment().apply {
            arguments = bundleOf(NotesRegistrationFragment.EMAIL to emailParam)
        }
    }
}