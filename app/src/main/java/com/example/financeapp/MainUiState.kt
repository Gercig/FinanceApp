package com.example.financeapp

internal const val INITIAL_BALANCE = 25_000

internal data class MainUiState(
    val balance: Int = INITIAL_BALANCE,
    val transactionCount: Int = 0,
)

internal enum class TransactionType {
    INCOME,
    EXPENSE,
}

internal data class Transaction(
    val type: TransactionType,
    val amount: Int,
)

internal sealed interface MainUiEvent {
    data class AddTransaction(val transaction: Transaction) : MainUiEvent
}
