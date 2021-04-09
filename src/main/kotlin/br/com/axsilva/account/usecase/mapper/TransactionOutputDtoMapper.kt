package br.com.axsilva.account.usecase.mapper

import br.com.axsilva.account.`input-boundary`.dto.TransactionInputDTO
import br.com.axsilva.account.`output-boundary`.repository.dto.TransactionOutputDTO

class TransactionOutputDtoMapper {
    companion object {
        fun TransactionInputDTO.mapperFrom(): TransactionOutputDTO {
            return TransactionOutputDTO(
                destinationAccount = this.destinationAccount.clientCode.toString(),
                originAccount = this.originAccount.clientCode.toString(),
                money = this.money
            )
        }
    }
}