# Intent 03: Dashboard & Analytics Specification

## Goal
Present a unified dashboard showing total balance, monthly spending summaries, Canvas charts, and recent activity (notes & transactions).

## Core UI Components
1. **Summary Card**: Net Balance, Total Income (this month), Total Expenses (this month).
2. **Quick Actions**: Floating Action Button menu ("Add Note", "Add Expense", "Add Income").
3. **Analytics Charts**: Custom Jetpack Compose Canvas bar chart for monthly spending and pie chart for category distribution.
4. **Recent Activity List**: Chronological feed of recent notes and transactions.

## Acceptance Criteria
1. Opening the app displays the summary card with real-time recalculated totals.
2. User can toggle between monthly, weekly, and yearly chart views.
3. Tapping a category in the pie chart filters transactions for that category.
