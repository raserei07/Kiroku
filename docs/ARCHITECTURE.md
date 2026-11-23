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
* **Dependency Injection**: Dagger Hilt with KSP for compile-time dependency injection (`@HiltAndroidApp`, `@AndroidEntryPoint`, `@HiltViewModel`).
* **Navigation Architecture**: Single-Activity Jetpack Compose Navigation (`KirokuNavHost`) paired with an extensible `AppNavigator` abstraction for modular Activity-to-Activity transitions.
* **Security**: AndroidX BiometricPrompt for local app security.

## Navigation & Activity Modularity
* **Primary Navigation**: Single-Activity Jetpack Compose Navigation (`KirokuNavHost` with type-safe `Screen` destinations).
* **Activity-to-Activity Modularity**: Interfaced via `AppNavigator` (`com.example.kiroku.ui.navigation.AppNavigator`). Enables in-app Compose routing (`navigateTo`, `popBackStack`) while providing modular support (`launchActivity`, `launchActivityClass`) for launching dedicated feature Activities in special edgecases (e.g., Biometric PIN Lock, Media Capture, or Export/Import sub-activities).
