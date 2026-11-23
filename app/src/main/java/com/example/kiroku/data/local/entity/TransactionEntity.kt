package com.example.kiroku.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val amount: Double,
    val type: String, // "INCOME", "EXPENSE", "TRANSFER"
    val categoryId: Long,
    val accountId: Long,
    val dateEpochMillis: Long,
    val linkedNoteId: Long? = null,
    val noteSnippet: String? = null
)
