package br.com.axsilva.account.web.mapper

import br.com.axsilva.account.`input-boundary`.dto.AccountInputDTO
import br.com.axsilva.account.`input-boundary`.dto.TransactionInputDTO
import br.com.axsilva.account.web.dto.TransactionWebDTO

class TransactionInputDtoMapper {
    companion object {
        fun TransactionWebDTO.mapperFrom(): TransactionInputDTO {
            return TransactionInputDTO(
                originAccount = AccountInputDTO(
                    this.originAccount.clientCode,
                    this.originAccount.agency
                ),
                destinationAccount = AccountInputDTO(
                    this.destinationAccount.clientCode,
                    this.destinationAccount.agency
                ),
                money = this.money
            )
        }
    }
}