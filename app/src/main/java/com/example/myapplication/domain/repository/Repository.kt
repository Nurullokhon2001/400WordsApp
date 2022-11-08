package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.*

interface Repository {
    suspend fun getVocabulary(): List<VocabularyModel>
    suspend fun searchVocabulary(words :String): List<VocabularyModel>
    suspend fun getSound(id : Int): Sounds
}