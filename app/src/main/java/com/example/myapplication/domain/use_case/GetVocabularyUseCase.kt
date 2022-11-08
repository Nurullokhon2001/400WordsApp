package com.example.myapplication.domain.use_case

import com.example.myapplication.domain.model.VocabularyModel
import com.example.myapplication.domain.repository.Repository
import javax.inject.Inject

class GetVocabularyUseCase @Inject constructor(val repository: Repository) {
    suspend operator fun invoke(): List<VocabularyModel> {
        return repository.getVocabulary()
    }
}