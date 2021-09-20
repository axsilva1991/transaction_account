package br.com.axsilva.account.web.dto

data class TransactionWebDTO(
    val origin: AccountWebDTO,
    val destination: AccountWebDTO,
    val money : Double
)