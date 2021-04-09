package br.com.axsilva.account.repository.`interface`

import br.com.axsilva.account.repository.entity.TransactionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepositoryInterface : JpaRepository<TransactionEntity, Long>{
    fun save(transactionEntity: TransactionEntity): TransactionEntity
}