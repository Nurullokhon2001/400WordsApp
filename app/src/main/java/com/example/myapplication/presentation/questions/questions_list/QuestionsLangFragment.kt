package com.example.myapplication.presentation.questions.questions_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentQuestionsLangBinding


class QuestionsLangFragment : Fragment() {

    private val args : QuestionsLangFragmentArgs by navArgs()

    private var _binding: FragmentQuestionsLangBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionsLangBinding.inflate(layoutInflater, container, false)
        binding.tvTajRus.setOnClickListener { navigateAndSendQuestionsId(1,args.quizType) }
        binding.tvRusTaj.setOnClickListener { navigateAndSendQuestionsId(2,args.quizType) }
        binding.tvEngTaj.setOnClickListener { navigateAndSendQuestionsId(3,args.quizType) }
        binding.tvEngRus.setOnClickListener { navigateAndSendQuestionsId(4,args.quizType) }
        binding.tvRusEng.setOnClickListener { navigateAndSendQuestionsId(5,args.quizType) }
        binding.tvTajEng.setOnClickListener { navigateAndSendQuestionsId(6,args.quizType) }
        return binding.root
    }

    private fun navigateAndSendQuestionsId(id: Int,quizId:Int) {
        if (quizId == 1){
            val idQuestion = QuestionsLangFragmentDirections.actionQuestionsFragmentToTestFragment(id)
            findNavController().navigate(idQuestion)
        }else if (quizId == 2){
            val idQuestion = QuestionsLangFragmentDirections.actionQuestionsFragmentToQuizFragment(id)
            findNavController().navigate(idQuestion)
        }

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}