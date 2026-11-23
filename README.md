# 記録 (Kiroku) - Note Keeper & Financial Tracker

Kiroku is an offline-first Android application that combines note-taking with personal financial tracking.

## 🚀 Intent-Driven Development (IDD)
This project follows **Intent-Driven Development**. Feature specifications, domain models, and acceptance criteria are documented in `docs/` before implementation:

* [`ARCHITECTURE.md`](docs/ARCHITECTURE.md) - System architecture, layer responsibilities, and security design.
* [`docs/intents/01_financial_tracker.md`](docs/intents/01_financial_tracker.md) - Specs for income, expenses, categories, and budgets.
* [`docs/intents/02_note_keeper.md`](docs/intents/02_note_keeper.md) - Specs for note creation, tags, formatting, and receipt linking.
* [`docs/intents/03_dashboard_analytics.md`](docs/intents/03_dashboard_analytics.md) - Specs for unified dashboard and Canvas charts.
* [`docs/intents/04_security_backup.md`](docs/intents/04_security_backup.md) - Specs for biometric lock, Room encryption, and local backup.

## 🛠️ Tech Stack
* **Language**: Kotlin
* **UI Framework**: Jetpack Compose + Material 3
* **Database**: Room (SQLCipher encrypted)
* **Async/State**: Kotlin Coroutines & `StateFlow`
* **Dependency Injection**: Koin
* **Architecture**: Clean Architecture (Presentation -> Domain -> Data)
