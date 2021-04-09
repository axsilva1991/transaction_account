package br.com.axsilva.account.`output-boundary`.repository

import br.com.axsilva.account.`output-boundary`.repository.dto.TransactionOutputDTO

interface TransactionRepository {
    fun save(transactionOutputDTO: TransactionOutputDTO)
}