package com.example.myapplication.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.domain.model.Sounds
import com.example.myapplication.domain.model.VocabularyListModel

@Database(entities = [VocabularyListModel::class, Sounds::class], version = 10 , exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): DbDao
}