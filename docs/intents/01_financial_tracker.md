# Intent 01: Financial Tracker Specification

## Goal
Provide a fast, intuitive system to log income and expenses, organize by category, track account balances, and monitor monthly budgets.

## Domain Entities
```kotlin
data class Transaction(
    val id: Long = 0,
    val title: String,
    val amount: Double,
    val type: TransactionType, // INCOME, EXPENSE, TRANSFER
    val categoryId: Long,
    val accountId: Long,
    val dateEpochMillis: Long,
    val linkedNoteId: Long? = null,
    val noteSnippet: String? = null
)

data class Category(
    val id: Long = 0,
    val name: String,
    val iconName: String,
    val colorHex: String,
    val type: TransactionType
)

data class Account(
    val id: Long = 0,
    val name: String,
    val initialBalance: Double,
    val currentBalance: Double,
    val accountType: String // Cash, Bank, Credit Card
)
```

## Acceptance Criteria
1. User can create, edit, and delete transactions.
2. User can assign transactions to categories (Food, Transport, Bills, Salary, etc.).
3. Adding an expense reduces the account balance; adding income increases it.
4. User can set category budget limits and receive visual warnings when spending exceeds 80% and 100% of the limit.
