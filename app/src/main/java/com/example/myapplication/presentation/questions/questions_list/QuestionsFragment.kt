package com.example.myapplication.presentation.questions.questions_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentQuestionsBinding

class QuestionsFragment : Fragment() {
    private var _binding: FragmentQuestionsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionsBinding.inflate(layoutInflater, container, false)
        binding.tvTajRus.setOnClickListener { navigateAndSendQuestionsId(1) }
        binding.tvRusTaj.setOnClickListener { navigateAndSendQuestionsId(2) }
        binding.tvEngTaj.setOnClickListener { navigateAndSendQuestionsId(3) }
        binding.tvEngRus.setOnClickListener { navigateAndSendQuestionsId(4) }
        binding.tvRusEng.setOnClickListener { navigateAndSendQuestionsId(5) }
        binding.tvTajEng.setOnClickListener { navigateAndSendQuestionsId(6) }
        return binding.root
    }

    private fun navigateAndSendQuestionsId(id: Int) {
        val idQuestion = QuestionsFragmentDirections.actionQuestionsFragmentToTestFragment(id)
        findNavController().navigate(idQuestion)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}