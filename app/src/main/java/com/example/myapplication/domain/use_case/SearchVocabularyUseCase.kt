package com.example.myapplication.domain.use_case

import com.example.myapplication.domain.model.VocabularyListModel
import com.example.myapplication.domain.repository.Repository
import javax.inject.Inject

class SearchVocabularyUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(words: String) : List<VocabularyListModel> {
        return repository.searchVocabulary(words)
    }
}