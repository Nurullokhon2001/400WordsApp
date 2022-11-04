package com.example.myapplication.data

import com.example.myapplication.data.data.Elements
import com.example.myapplication.data.room.DbDao
import com.example.myapplication.domain.model.*
import com.example.myapplication.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val elements: Elements,
    private val dbDao: DbDao
) : Repository {

    override suspend fun getVocabulary(): List<VocabularyListModel> {
        return dbDao.getVocabulary()
    }

    override suspend fun searchVocabulary(words: String): List<VocabularyListModel> {
        return dbDao.searchVocabulary(words)
    }

    override fun getElementsById(id: Int): VocabularyListModel {
        return elements.getElementsById(id)
    }

    override suspend fun getSound(id: Int): Sounds {
        return dbDao.getSound(id)
    }

    override fun getDetailsElementById(id: Int): ElementDetailsModel {
        return elements.getDetailsElementById(id)
    }

    override fun getQuestions(): List<Question> {
        return elements.getQuestions()
    }

    override fun getFormulas(): List<FormulasModel> {
        return elements.getFormulas()
    }
}