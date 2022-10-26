package com.example.myapplication.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class VocabularyListModel(
    @PrimaryKey val id: Int,
    var tjk: String,
    var rus: String?,
    var eng: String?,
)