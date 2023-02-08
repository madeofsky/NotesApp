package com.lukita.notesapp.home

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.lukita.notesapp.NotesApplication
import com.lukita.notesapp.R
import com.lukita.notesapp.appenter.di.component.NotesAppEnterActivityComponent
import com.lukita.notesapp.databinding.ActivityNotesHomeBinding
import com.lukita.notesapp.home.di.NotesHomeActivityComponent
import com.lukita.notesapp.home.presentation.NotesHomeViewModel
import javax.inject.Inject

class NotesHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotesHomeBinding

    @Inject
    lateinit var viewModel: NotesHomeViewModel

    val activityComponent: NotesHomeActivityComponent by lazy {
        (application as NotesApplication).appComponent.notesHomeComponent().create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent.inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivityNotesHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        val drawerLayout = binding.notesHomeDrawer
        //Add a toolbar
        val toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.notesHomeNavView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_logout -> {
                    viewModel.onLogoutClick()
                }
            }
            drawerLayout.closeDrawers()
            true
        }
    }
}