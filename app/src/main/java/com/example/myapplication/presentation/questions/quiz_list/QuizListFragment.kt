package com.example.myapplication.presentation.questions.quiz_list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentQuizListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuizListFragment: Fragment() {

    private var _binding: FragmentQuizListBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizListBinding.inflate(layoutInflater, container, false)

        binding.tvTest.setOnClickListener {
            findNavController().navigate(R.id.action_quizListFragment_to_questionsFragment)
        }

        binding.tvQuiz.setOnClickListener {
            findNavController().navigate(R.id.action_quizListFragment_to_quizFragment)
        }


        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}