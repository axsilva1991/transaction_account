package br.com.axsilva.account.`output-boundary`.repository.dto

data class TransactionOutputDTO(
    val originAccount: String,
    val destinationAccount: String,
    val money : Double
)