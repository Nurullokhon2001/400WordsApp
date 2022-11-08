package com.example.myapplication.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.domain.model.Sounds
import com.example.myapplication.domain.model.VocabularyModel

@Database(entities = [VocabularyModel::class, Sounds::class], version = 10 , exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): DbDao
}