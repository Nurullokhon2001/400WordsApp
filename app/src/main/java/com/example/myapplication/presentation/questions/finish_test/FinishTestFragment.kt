package com.example.myapplication.presentation.questions.finish_test

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentFinishTestBinding

class FinishTestFragment : Fragment() {
    private val args: FinishTestFragmentArgs by navArgs()

    private var _binding: FragmentFinishTestBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFinishTestBinding.inflate(layoutInflater, container, false)
        binding.correctAnswer.text = "Ҷавоби дуруст ${args.correctAnswer} - то"
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}