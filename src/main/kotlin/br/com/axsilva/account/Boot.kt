package br.com.axsilva.account

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TransactionAccountApplication

fun main(args: Array<String>) {
	runApplication<TransactionAccountApplication>(*args)
}
