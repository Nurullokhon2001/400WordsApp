package com.example.myapplication.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sounds")
data class Sounds(
    @PrimaryKey val id: Int,
    var path: String,
)