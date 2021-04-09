package br.com.axsilva.account.usecase

import br.com.axsilva.account.`input-boundary`.Transaction
import br.com.axsilva.account.`input-boundary`.dto.AccountInputDTO
import br.com.axsilva.account.`input-boundary`.dto.TransactionInputDTO
import br.com.axsilva.account.`input-boundary`.exception.BadInputValuesException
import br.com.axsilva.account.`output-boundary`.repository.TransactionRepository
import br.com.axsilva.account.domain.Account
import br.com.axsilva.account.domain.Client
import br.com.axsilva.account.domain.exception.InvalidValueException
import br.com.axsilva.account.domain.exception.TransferDefautlException
import br.com.axsilva.account.usecase.mapper.TransactionOutputDtoMapper.Companion.mapperFrom
import org.springframework.stereotype.Service

@Service
class TransactionUseCase(private val transactionRepository: TransactionRepository) : Transaction {

    override fun transferFor(transactionInputDTO: TransactionInputDTO) {
        try {
            val originAccount = mapperFrom(transactionInputDTO.originAccount)
            val destinationAccount = mapperFrom(transactionInputDTO.destinationAccount)

            originAccount.transfer(transactionInputDTO.money, destinationAccount)

            transactionRepository.save(transactionInputDTO.mapperFrom())
        } catch (ex: TransferDefautlException) {
            throw BadInputValuesException(ex.message!!)
        }
    }

    private fun mapperFrom(accountInputDTO: AccountInputDTO): Account {
        try {
            return Account(
                agency = accountInputDTO.agency,
                client = Client(accountInputDTO.clientCode),
                code = accountInputDTO.clientCode)
        } catch (ex: InvalidValueException) {
            throw BadInputValuesException(ex.message)
        }
    }
}