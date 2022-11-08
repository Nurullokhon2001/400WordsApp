package com.example.myapplication.presentation.questions.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.VocabularyModel
import com.example.myapplication.domain.quiz_use_case.QuizTjEngUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val quizTjEngUseCase: QuizTjEngUseCase,
) : ViewModel() {

    fun getVocabulary(id: Int): LiveData<VocabularyModel> {
        val list = MutableLiveData<VocabularyModel>()
        viewModelScope.launch {
            list.value = quizTjEngUseCase.invoke(id)
        }
        return list
    }

}