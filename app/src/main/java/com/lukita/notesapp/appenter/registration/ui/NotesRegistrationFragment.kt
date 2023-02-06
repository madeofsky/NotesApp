package com.lukita.notesapp.appenter.registration.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.lukita.notesapp.R
import com.lukita.notesapp.appenter.NotesAppEnterActivity
import com.lukita.notesapp.appenter.login.ui.NotesLoginFragment
import com.lukita.notesapp.appenter.registration.data.UserRegistrationInfo
import com.lukita.notesapp.appenter.registration.presentation.NotesRegistrationViewModel
import com.lukita.notesapp.appenter.registration.presentation.RegistrationEvents
import com.lukita.notesapp.databinding.FragmentNotesRegistrationBinding
import com.lukita.notesapp.utils.replaceFragment
import javax.inject.Inject

class NotesRegistrationFragment : Fragment() {

    private lateinit var binding: FragmentNotesRegistrationBinding

    @Inject
    lateinit var viewModel: NotesRegistrationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        (requireActivity() as NotesAppEnterActivity).activityComponent.notesRegistrationComponent().create().inject(this)
        binding = FragmentNotesRegistrationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initViewModel()
    }

    private fun initViews() {
        binding.layoutRegisterCard.textViewSingIn.setOnClickListener {
            viewModel.onSignInClick()
        }
        binding.layoutRegisterCard.buttonSingUp.setOnClickListener {
            val fullName = binding.layoutRegisterCard.editTextName.text.toString()
            val mobileNumber = binding.layoutRegisterCard.editTextMobileNumber.text.toString()
            val email = binding.layoutRegisterCard.editTextEmail.text.toString()
            val password = binding.layoutRegisterCard.editTextPassword.text.toString()

            if (email.isNotBlank() && password.isNotBlank()) viewModel.onRegisterClick(
                UserRegistrationInfo(fullName, mobileNumber, email, password)
            )
            else Toast.makeText(context, "Please, fill with your information to Register!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initViewModel() {
        viewModel.registrationEvents.observe(viewLifecycleOwner) { event ->
            when (event) {
                is RegistrationEvents.SendUserToLoginScreen -> navigateToLoginFragment(event.user?.email)
                RegistrationEvents.ShowErrorToast -> Toast.makeText(requireContext(), "Server Error", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun navigateToLoginFragment(email: String?) {
        val loginFragment = NotesLoginFragment.newInstance(email)
        activity?.supportFragmentManager?.replaceFragment(R.id.container, loginFragment)
    }

    companion object {
        const val EMAIL = "email"
    }
}