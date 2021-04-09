package br.com.axsilva.account.repository.impl

import br.com.axsilva.account.`output-boundary`.repository.TransactionRepository
import br.com.axsilva.account.`output-boundary`.repository.dto.TransactionOutputDTO
import br.com.axsilva.account.repository.`interface`.TransactionRepositoryInterface
import br.com.axsilva.account.repository.entity.TransactionEntity
import br.com.axsilva.account.repository.mapper.TransactionEntityDtoMapper.Companion.mapperFrom
import org.springframework.stereotype.Service

@Service
class TransactionRepositoryImpl(
    private val taskRepositoryInterface: TransactionRepositoryInterface
) : TransactionRepository {
    override fun save(transactionOutputDTO: TransactionOutputDTO) {
        taskRepositoryInterface
            .save(transactionOutputDTO.mapperFrom())
    }
}