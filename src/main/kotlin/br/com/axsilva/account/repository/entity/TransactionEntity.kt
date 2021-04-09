package br.com.axsilva.account.repository.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class TransactionEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val origin: String,
    val destination: String,
    val money: Double,
    val date: LocalDateTime = LocalDateTime.now()
)