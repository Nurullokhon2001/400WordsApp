package com.example.myapplication.domain.quiz_use_case

import com.example.myapplication.domain.model.VocabularyModel
import com.example.myapplication.domain.repository.Repository
import javax.inject.Inject

class QuizUseCase @Inject constructor(val repository: Repository) {

    suspend operator fun invoke(id: Int): VocabularyModel {
        return getWord(id)
    }


    private suspend fun getWord(id: Int): VocabularyModel {
        return repository.getVocabulary().shuffled()[id]
    }
}