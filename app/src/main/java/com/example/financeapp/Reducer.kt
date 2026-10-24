package com.example.financeapp

internal fun reduce(state: MainUiState, event: MainUiEvent): MainUiState = when (event) {
    is MainUiEvent.AddTransaction -> {
        val transaction = event.transaction
        require(transaction.amount > 0) { "Amount must be positive" }

        val change = when (transaction.type) {
            TransactionType.INCOME -> transaction.amount
            TransactionType.EXPENSE -> -transaction.amount
        }

        state.copy(
            balance = state.balance + change,
            transactionCount = state.transactionCount + 1,
        )
    }
}
