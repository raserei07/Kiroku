# Intent 04: Security & Backup Specification

## Goal
Ensure local user privacy through biometric authentication, database encryption, and local data export/import.

## Requirements
1. **Biometric & PIN Security**:
   * App lock preference in settings.
   * Prompts `BiometricPrompt` (Fingerprint/Face Unlock or device PIN) on app launch if security is enabled.
2. **Database Encryption**:
   * SQLCipher integration for Room database.
3. **Data Export & Import**:
   * Export all notes and transactions to an encrypted JSON or CSV file.
   * Import/restore data from local backup file.
