package br.com.axsilva.account.`input-boundary`.dto

data class TransactionInputDTO(
    val originAccount: AccountInputDTO,
    val destinationAccount: AccountInputDTO,
    val money : Double
)