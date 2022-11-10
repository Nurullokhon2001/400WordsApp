package com.example.myapplication.presentation.questions.quiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentQuizBinding
import com.example.myapplication.domain.model.VocabularyModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuizFragment : Fragment() {

    private val args: QuizFragmentArgs by navArgs()

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

        when (args.idQuestions) {
            1 -> {
                getRandomWordTjToRu()
            }
            2 -> {
                getRandomWordRuToTj()
            }
            3 -> {
                getRandomWordEngToTjk()
            }
            4 -> {
                getRandomWordEngToRu()
            }
            5 -> {
                getRandomWordRuToEng()
            }
            6 -> {
                getRandomWordTjToEng()
            }
        }

        binding.btnRandomWord.setOnClickListener {
            when (args.idQuestions) {
                1 -> {
                    getRandomWordTjToRu()
                }
                2 -> {
                    getRandomWordRuToTj()
                }
                3 -> {
                    getRandomWordEngToTjk()
                }
                4 -> {
                    getRandomWordEngToRu()
                }
                5 -> {
                    getRandomWordRuToEng()
                }
                6 -> {
                    getRandomWordTjToEng()
                }
            }


        }

        binding.btnCheckWord.setOnClickListener {
            when (args.idQuestions) {
                1 -> {
                    checkAnswerTjToRu(binding.etWord.text.toString())
                }
                2 -> {
                    checkAnswerRuToTj(binding.etWord.text.toString())
                }
                3 -> {
                    checkAnswerEngToTjk(binding.etWord.text.toString())

                }
                4 -> {
                    checkAnswerEngToRu(binding.etWord.text.toString())
                }
                5 -> {
                    checkAnswerRuToEng(binding.etWord.text.toString())
                }
                6 -> {
                    checkAnswerTjToEng(binding.etWord.text.toString())
                }
            }
        }

        binding.btnShowWord.setOnClickListener {
            when (args.idQuestions) {
                1 -> {
                    showWordTjToRu()
                }
                2 -> {
                    showWordRuToTj()
                }
                3 -> {
                    showWordEngToTjk()
                }
                4 -> {
                    showWordEngToRu()
                }
                5 -> {
                    showWordRuToEng()
                }
                6 -> {
                    showWordTjToEng()
                }
            }
        }

        return binding.root
    }


    // refactoring after publish to play market
// eng to tjk quiz
    @SuppressLint("SetTextI18n")
    private fun checkAnswerEngToTjk(answer: String) {
        if (answer.isNotBlank()) {
            if (word!!.tjk.uppercase().trim() == answer.uppercase().trim()) {
                binding.tvAnswer.text = "Чавоб дуруст !! \n ${word!!.tjk}"
            } else {
                binding.tvAnswer.text = "Чавоб хато"
            }
        }
    }

    private fun getRandomWordEngToTjk() {
        viewModel.getVocabulary((1..408).random()).observe(viewLifecycleOwner) {
            word = it
            binding.tvWord.text = word!!.eng
            binding.tilWord.isEnabled = true
            binding.etWord.setText("")
            binding.tvAnswer.text = ""
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showWordEngToTjk() {
        binding.tilWord.isEnabled = false
        binding.tvAnswer.text = "Чавоби дуруст !! \n ${word!!.tjk}"
    }
    // eng to ru quiz

    @SuppressLint("SetTextI18n")
    private fun checkAnswerEngToRu(answer: String) {
        val rusWords = word!!.rus!!.split(",")
        if (answer.isNotBlank()) {
            for (words in rusWords) {
                if (words.uppercase().trim() == answer.uppercase().trim()) {
                    binding.tvAnswer.text = "Чавоб дуруст !! \n ${word!!.rus}"
                    return
                } else {
                    binding.tvAnswer.text = "Чавоб хато"
                }
            }

        }
    }

    private fun getRandomWordEngToRu() {
        viewModel.getVocabulary((1..408).random()).observe(viewLifecycleOwner) {
            word = it
            binding.tvWord.text = word!!.eng
            binding.tilWord.isEnabled = true
            binding.etWord.setText("")
            binding.tvAnswer.text = ""
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showWordEngToRu() {
        binding.tilWord.isEnabled = false
        binding.tvAnswer.text = "Чавоби дуруст !! \n ${word!!.rus}"
    }

    // tj to ru quiz

    @SuppressLint("SetTextI18n")
    private fun checkAnswerTjToRu(answer: String) {
        val rusWords = word!!.rus!!.split(",")
        if (answer.isNotBlank()) {
            for (words in rusWords) {
                if (words.uppercase().trim() == answer.uppercase().trim()) {
                    binding.tvAnswer.text = "Чавоб дуруст !! \n ${word!!.rus}"
                    return
                } else {
                    binding.tvAnswer.text = "Чавоб хато"
                }
            }

        }
    }

    private fun getRandomWordTjToRu() {
        viewModel.getVocabulary((1..408).random()).observe(viewLifecycleOwner) {
            word = it
            binding.tvWord.text = word!!.tjk
            binding.tilWord.isEnabled = true
            binding.etWord.setText("")
            binding.tvAnswer.text = ""
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showWordTjToRu() {
        binding.tilWord.isEnabled = false
        binding.tvAnswer.text = "Чавоби дуруст !! \n ${word!!.rus}"
    }

    // ru to tj quiz

    @SuppressLint("SetTextI18n")
    private fun checkAnswerRuToTj(answer: String) {
        if (answer.isNotBlank()) {
            if (word!!.tjk.uppercase().trim() == answer.uppercase().trim()) {
                binding.tvAnswer.text = "Чавоб дуруст !! \n ${word!!.tjk}"
                return
            } else {
                binding.tvAnswer.text = "Чавоб хато"
            }
        }
    }

    private fun getRandomWordRuToTj() {
        viewModel.getVocabulary((1..408).random()).observe(viewLifecycleOwner) {
            word = it
            binding.tvWord.text = word!!.rus
            binding.tilWord.isEnabled = true
            binding.etWord.setText("")
            binding.tvAnswer.text = ""
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showWordRuToTj() {
        binding.tilWord.isEnabled = false
        binding.tvAnswer.text = "Чавоби дуруст !! \n ${word!!.tjk}"
    }

    // ru to eng
    @SuppressLint("SetTextI18n")
    private fun checkAnswerRuToEng(answer: String) {
        val engWords = word!!.eng!!.split(",")
        if (answer.isNotBlank()) {
           for (engWord in engWords){
               if (engWord.substringBefore("[").uppercase().trim() == answer.uppercase().trim()) {
                   binding.tvAnswer.text = "Чавоб дуруст !! \n ${word!!.eng}"
                   return
               } else {
                   binding.tvAnswer.text = "Чавоб хато"
               }
           }
        }
    }

    private fun getRandomWordRuToEng() {
        viewModel.getVocabulary((1..408).random()).observe(viewLifecycleOwner) {
            word = it
            binding.tvWord.text = word!!.rus
            binding.tilWord.isEnabled = true
            binding.etWord.setText("")
            binding.tvAnswer.text = ""
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showWordRuToEng() {
        binding.tilWord.isEnabled = false
        binding.tvAnswer.text = "Чавоби дуруст !! \n ${word!!.eng}"
    }

    // tj to eng
    @SuppressLint("SetTextI18n")
    private fun checkAnswerTjToEng(answer: String) {
        val engWords = word!!.eng!!.split(",")
        if (answer.isNotBlank()) {
            for (engWord in engWords){
                if (engWord.substringBefore("[").uppercase().trim() == answer.uppercase().trim()) {
                    binding.tvAnswer.text = "Чавоб дуруст !! \n ${word!!.eng}"
                    return
                } else {
                    binding.tvAnswer.text = "Чавоб хато"
                }
            }
        }
    }

    private fun getRandomWordTjToEng() {
        viewModel.getVocabulary((1..408).random()).observe(viewLifecycleOwner) {
            word = it
            binding.tvWord.text = word!!.tjk
            binding.tilWord.isEnabled = true
            binding.etWord.setText("")
            binding.tvAnswer.text = ""
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showWordTjToEng() {
        binding.tilWord.isEnabled = false
        binding.tvAnswer.text = "Чавоби дуруст !! \n ${word!!.eng}"
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}