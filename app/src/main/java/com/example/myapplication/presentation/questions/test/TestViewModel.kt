package com.example.myapplication.presentation.questions.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.Question
import com.example.myapplication.domain.questions_use_case.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val getTajRuQuestionsUseCase: GetTajRuQuestionsUseCase,
    private val getRusTajQuestionsUseCase: GetRusTajQuestionsUseCase,
    private val getEngTajQuestionsUseCase: GetEngTajQuestionsUseCase,
    private val getEngRuQuestionsUseCase: GetEngRuQuestionsUseCase,
    private val getRusEngQuestionsUseCase: GetRusEngQuestionsUseCase,
    private val getTajEngQuestionsUseCase: GetTajEngQuestionsUseCase,
) : ViewModel() {

    fun getQuestions(idQuestion: Int): LiveData<List<Question>> {
        val question = MutableLiveData<List<Question>>()
        viewModelScope.launch {
            when (idQuestion) {
                1 -> {
                    question.value = getTajRuQuestionsUseCase.invoke()
                }
                2 -> {
                    question.value = getRusTajQuestionsUseCase.invoke()
                }
                3 -> {
                    question.value = getEngTajQuestionsUseCase.invoke()
                }
                4 -> {
                    question.value = getEngRuQuestionsUseCase.invoke()
                }
                5 -> {
                    question.value = getRusEngQuestionsUseCase.invoke()
                }
                6 -> {
                    question.value = getTajEngQuestionsUseCase.invoke()
                }
            }
        }
        return question
    }
}