package com.example.myapplication.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.domain.model.VocabularyListModel

@Database(entities = [VocabularyListModel::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): DbDao
}