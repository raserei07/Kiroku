package com.example.kiroku.di

import android.content.Context
import android.util.Base64
import androidx.room.Room
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.kiroku.data.local.KirokuDatabase
import com.example.kiroku.data.local.dao.AccountDao
import com.example.kiroku.data.local.dao.CategoryDao
import com.example.kiroku.data.local.dao.NoteDao
import com.example.kiroku.data.local.dao.TransactionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SupportFactory
import java.security.SecureRandom
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val SECURE_PREFS_NAME = "kiroku_secure_prefs"
    private const val DB_KEY_ALIAS = "kiroku_db_passphrase"

    @Provides
    @Singleton
    fun provideEncryptedPassphrase(@ApplicationContext context: Context): ByteArray {
        val masterKey = MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        val securePrefs = EncryptedSharedPreferences.create(
            context,
            SECURE_PREFS_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        var passphraseStr = securePrefs.getString(DB_KEY_ALIAS, null)
        if (passphraseStr == null) {
            val randomBytes = ByteArray(32)
            SecureRandom().nextBytes(randomBytes)
            passphraseStr = Base64.encodeToString(randomBytes, Base64.NO_WRAP)
            securePrefs.edit().putString(DB_KEY_ALIAS, passphraseStr).apply()
        }

        return Base64.decode(passphraseStr, Base64.NO_WRAP)
    }

    @Provides
    @Singleton
    fun provideKirokuDatabase(
        @ApplicationContext context: Context,
        passphrase: ByteArray
    ): KirokuDatabase {
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            KirokuDatabase::class.java,
            KirokuDatabase.DATABASE_NAME
        )
            .openHelperFactory(factory)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideNoteDao(database: KirokuDatabase): NoteDao = database.noteDao()

    @Provides
    fun provideTransactionDao(database: KirokuDatabase): TransactionDao = database.transactionDao()

    @Provides
    fun provideCategoryDao(database: KirokuDatabase): CategoryDao = database.categoryDao()

    @Provides
    fun provideAccountDao(database: KirokuDatabase): AccountDao = database.accountDao()
}
