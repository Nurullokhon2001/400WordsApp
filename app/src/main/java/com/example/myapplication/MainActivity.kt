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
                R.id.aboutFragment
            ),
        )

        binding.toolbar.setupWithNavController(navController, appBatConfiguration)
        binding.bottomNavigation.setupWithNavController(
            navController
        )

        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {
                R.id.elementListFragment -> {
                    supportActionBar?.title = "Калимаҳо"
                    hideBottomNavigation(true)
                }
                R.id.testFragment -> {
                    hideBottomNavigation(false)
                }
                R.id.questionsFragment ->{
                    hideBottomNavigation(true)
                }
                R.id.finishTestFragment ->{
                    hideBottomNavigation(true)
                }
            }
        }
    }

    private fun hideBottomNavigation(isVisible : Boolean){
        binding.bottomNavigation.isVisible = isVisible
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}