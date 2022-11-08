package com.example.myapplication.presentation.questions.quiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.databinding.FragmentQuizBinding
import com.example.myapplication.domain.model.VocabularyModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuizFragment : Fragment() {

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<QuizViewModel>()

    private var word: VocabularyModel? = null

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(layoutInflater, container, false)

        getRandomWord()

        binding.btnRandomWord.setOnClickListener {
            getRandomWord()
        }

        binding.btnCheckWord.setOnClickListener {
            checkAnswer(binding.etWord.text.toString())
        }

        binding.btnShowWord.setOnClickListener {
            showWord()
        }

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun checkAnswer(answer: String) {
        if (answer.isNotBlank()) {
            if (word!!.tjk.uppercase().trim() == answer.uppercase().trim()){
                binding.tvAnswer.text = "Чавоб дуруст !! \n ${word!!.tjk}"
            }else{
                binding.tvAnswer.text = "Чавоб хато"
            }
        }
    }

    private fun getRandomWord() {
        viewModel.getVocabulary((1..408).random()).observe(viewLifecycleOwner) {
            word = it
            binding.tvWord.text = word!!.eng
            binding.tilWord.isEnabled = true
            binding.etWord.setText("")
            binding.tvAnswer.text = ""
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showWord() {
        binding.tilWord.isEnabled = false
        binding.tvAnswer.text = "Чавоби дуруст !! \n ${word!!.tjk}"
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}