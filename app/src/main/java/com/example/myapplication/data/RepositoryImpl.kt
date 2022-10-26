package com.example.myapplication.data

import com.example.myapplication.data.data.Elements
import com.example.myapplication.data.room.DbDao
import com.example.myapplication.domain.model.ElementDetailsModel
import com.example.myapplication.domain.model.VocabularyListModel
import com.example.myapplication.domain.model.FormulasModel
import com.example.myapplication.domain.model.Question
import com.example.myapplication.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val elements: Elements,
    private val dbDao : DbDao
) : Repository {

   override suspend fun getVocabulary(): List<VocabularyListModel> {
        return dbDao.getVocabulary()
    }

    override fun getElementsById(id: Int): VocabularyListModel {
        return elements.getElementsById(id)
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