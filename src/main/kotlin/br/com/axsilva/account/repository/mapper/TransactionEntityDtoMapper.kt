package br.com.axsilva.account.repository.mapper

import br.com.axsilva.account.`input-boundary`.dto.AccountInputDTO
import br.com.axsilva.account.`input-boundary`.dto.TransactionInputDTO
import br.com.axsilva.account.`output-boundary`.repository.dto.TransactionOutputDTO
import br.com.axsilva.account.repository.entity.TransactionEntity
import br.com.axsilva.account.web.dto.TransactionWebDTO

class TransactionEntityDtoMapper {
    companion object {
        fun TransactionOutputDTO.mapperFrom(): TransactionEntity {
            return TransactionEntity(
                origin = this.originAccount,
                money = this.money,
                destination = this.destinationAccount
            )
        }
    }
}