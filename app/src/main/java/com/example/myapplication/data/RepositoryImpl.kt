package com.example.myapplication.data

import com.example.myapplication.data.room.DbDao
import com.example.myapplication.domain.model.*
import com.example.myapplication.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dbDao: DbDao
) : Repository {

    override suspend fun getVocabulary(): List<VocabularyModel> {
        return dbDao.getVocabulary()
    }

    override suspend fun searchVocabulary(words: String): List<VocabularyModel> {
        return dbDao.searchVocabulary(words)
    }


    override suspend fun getSound(id: Int): Sounds {
        return dbDao.getSound(id)
    }
}