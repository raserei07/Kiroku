# System Architecture

## Overview
Kiroku follows **Clean Architecture** principles and a **Unidirectional Data Flow (UDF)** model using Jetpack Compose and `StateFlow`.

```
┌────────────────────────────────────────────────────────┐
│                   Presentation Layer                   │
│          (Jetpack Compose UI + ViewModels)             │
└───────────────────────────┬────────────────────────────┘
                            │
┌───────────────────────────▼────────────────────────────┐
│                      Domain Layer                      │
│            (Use Cases & Domain Entities)               │
└───────────────────────────┬────────────────────────────┘
                            │
┌───────────────────────────▼────────────────────────────┐
│                       Data Layer                       │
│    (Repositories, Room DAOs, Encrypted Database)       │
└────────────────────────────────────────────────────────┘
```

## Tech Stack Choices
* **Database**: Room Database with SQLCipher encryption.
* **State Management**: `StateFlow` and `UiState` sealed interfaces in ViewModels.
* **Dependency Injection**: Koin for lightweight Kotlin-first DI.
* **Navigation**: Single-Activity Jetpack Compose Navigation (`androidx.navigation:navigation-compose`).
* **Security**: AndroidX BiometricPrompt for local app security.
