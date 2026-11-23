package com.example.kiroku.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val initialBalance: Double,
    val currentBalance: Double,
    val accountType: String // "Cash", "Bank", "Credit Card"
)
