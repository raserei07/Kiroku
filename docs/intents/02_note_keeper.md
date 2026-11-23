# Intent 02: Note Keeper Specification

## Goal
Provide a flexible note-taking system supporting rich text, tags, search, pinning, and linking notes to financial transactions.

## Domain Entities
```kotlin
data class Note(
    val id: Long = 0,
    val title: String,
    val content: String,
    val createdAtEpochMillis: Long,
    val updatedAtEpochMillis: Long,
    val isPinned: Boolean = false,
    val colorHex: String? = null,
    val tags: List<String> = emptyList(),
    val linkedTransactionId: Long? = null
)
```

## Acceptance Criteria
1. User can create, edit, pin, and delete notes.
2. Notes can be filtered by tags or searched by keyword across title and content.
3. User can link a financial transaction to a note (e.g., attaching a receipt note to an expense).
4. Auto-save note draft when user navigates away.
