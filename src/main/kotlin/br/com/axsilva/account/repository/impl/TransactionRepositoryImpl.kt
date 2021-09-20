package br.com.axsilva.account.repository.impl

import br.com.axsilva.account.`output-boundary`.repository.TransactionRepository
import br.com.axsilva.account.`output-boundary`.repository.dto.TransactionOutputDTO
import br.com.axsilva.account.repository.`interface`.TransactionRepositoryInterface
import br.com.axsilva.account.repository.mapper.TransactionEntityDtoMapper.Companion.mapperFrom
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TransactionRepositoryImpl(
    private val taskRepositoryInterface: TransactionRepositoryInterface
) : TransactionRepository {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun save(transactionOutputDTO: TransactionOutputDTO) {
        log.info("TransactionRepositoryImpl.save() = TransactionOutputDTO:-> {}", transactionOutputDTO)
        taskRepositoryInterface
            .save(transactionOutputDTO.mapperFrom())
    }
}