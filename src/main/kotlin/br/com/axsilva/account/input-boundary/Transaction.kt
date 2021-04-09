package br.com.axsilva.account.`input-boundary`

import br.com.axsilva.account.`input-boundary`.dto.TransactionInputDTO

interface Transaction {
    fun transferFor(transactionInputDTO: TransactionInputDTO)
}
