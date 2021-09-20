package br.com.axsilva.account.web.mapper

import br.com.axsilva.account.`input-boundary`.dto.AccountInputDTO
import br.com.axsilva.account.`input-boundary`.dto.TransactionInputDTO
import br.com.axsilva.account.web.dto.TransactionWebDTO

class TransactionInputDtoMapper {
    companion object {
        fun TransactionWebDTO.mapperFrom(): TransactionInputDTO {
            return TransactionInputDTO(
                originAccount = AccountInputDTO(
                    this.origin.clientCode,
                    this.origin.agency
                ),
                destinationAccount = AccountInputDTO(
                    this.destination.clientCode,
                    this.destination.agency
                ),
                money = this.money
            )
        }
    }
}