package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        initViews()
    }

    private fun initViews() {
        val navController = findNavController(R.id.fragment)
        val appBatConfiguration = AppBarConfiguration(
            setOf(
                R.id.elementListFragment,
                R.id.questionsFragment,
                R.id.formulasFragment
            ),
        )

        binding.toolbar.setupWithNavController(navController, appBatConfiguration)
        binding.bottomNavigation.setupWithNavController(
            navController
        )

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.bottomNavigation.isVisible =
                !(destination.id == R.id.detailsFragment &&
                        destination.id != R.id.testFragment &&
                        destination.id != R.id.finishTestFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}