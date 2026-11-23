package com.example.kiroku.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val content: String,
    val createdAtEpochMillis: Long,
    val updatedAtEpochMillis: Long,
    val isPinned: Boolean = false,
    val colorHex: String? = null,
    val tagsCsv: String = "", // comma-separated tags
    val linkedTransactionId: Long? = null
)
