package com.example.kiroku.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kiroku.data.local.dao.AccountDao
import com.example.kiroku.data.local.dao.CategoryDao
import com.example.kiroku.data.local.dao.NoteDao
import com.example.kiroku.data.local.dao.TransactionDao
import com.example.kiroku.data.local.entity.AccountEntity
import com.example.kiroku.data.local.entity.CategoryEntity
import com.example.kiroku.data.local.entity.NoteEntity
import com.example.kiroku.data.local.entity.TransactionEntity

@Database(
    entities = [
        NoteEntity::class,
        TransactionEntity::class,
        CategoryEntity::class,
        AccountEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class KirokuDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun transactionDao(): TransactionDao
    abstract fun categoryDao(): CategoryDao
    abstract fun accountDao(): AccountDao

    companion object {
        const val DATABASE_NAME = "kiroku_encrypted.db"
    }
}
