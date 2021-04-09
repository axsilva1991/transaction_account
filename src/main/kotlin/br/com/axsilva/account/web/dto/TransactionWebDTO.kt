package br.com.axsilva.account.web.dto

data class TransactionWebDTO(
    val originAccount: AccountWebDTO,
    val destinationAccount: AccountWebDTO,
    val money : Double
)