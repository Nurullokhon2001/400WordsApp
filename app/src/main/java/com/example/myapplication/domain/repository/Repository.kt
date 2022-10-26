package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.ElementDetailsModel
import com.example.myapplication.domain.model.VocabularyListModel
import com.example.myapplication.domain.model.FormulasModel
import com.example.myapplication.domain.model.Question

interface Repository {
    suspend fun getVocabulary(): List<VocabularyListModel>
    fun getElementsById(id : Int): VocabularyListModel
    fun getDetailsElementById(id : Int): ElementDetailsModel
    fun getQuestions():List<Question>
    fun getFormulas():List<FormulasModel>
}