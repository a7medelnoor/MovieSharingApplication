package com.a7medelnoor.moviesharingapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.a7medelnoor.moviesharingapplication.R
import com.a7medelnoor.moviesharingapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // setup toolbar

        setSupportActionBar(binding.toolbar)
        // setup bottom navigation
        navController = findNavController(R.id.fragmentContainerView)
        var appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.movies_fragment,
                R.id.favorites_fragment
            )
        )
        // setup with navController
        bottom_navigation_view.setupWithNavController(navController)
        // setup action bar with navController
        setupActionBarWithNavController(navController,appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return  navController.navigateUp() || super.onSupportNavigateUp()
    }
}