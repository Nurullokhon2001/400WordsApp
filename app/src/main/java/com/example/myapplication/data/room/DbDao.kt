package com.example.myapplication.data.room

import androidx.room.Dao
import androidx.room.Query
import com.example.myapplication.domain.model.VocabularyListModel

@Dao
interface DbDao {
    @Query("Select * from words ")
    suspend fun getVocabulary(): List<VocabularyListModel>

    @Query("Select * from words where tjk Like :words or rus Like :words or eng Like :words")
    suspend fun searchVocabulary(words : String):List<VocabularyListModel>
}