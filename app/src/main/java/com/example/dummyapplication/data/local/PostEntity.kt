package com.example.dummyapplication.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PostEntityTable")
data class PostEntity(
    @PrimaryKey
    val id: Int,
    val body: String,

    val title: String,
)
