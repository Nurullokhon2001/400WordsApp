package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.*

interface Repository {
    suspend fun getVocabulary(): List<VocabularyModel>
    suspend fun searchVocabulary(words :String): List<VocabularyModel>
    fun getElementsById(id : Int): VocabularyModel
    suspend fun getSound(id : Int): Sounds
    fun getDetailsElementById(id : Int): ElementDetailsModel
    fun getQuestions():List<Question>
    fun getFormulas():List<FormulasModel>
}