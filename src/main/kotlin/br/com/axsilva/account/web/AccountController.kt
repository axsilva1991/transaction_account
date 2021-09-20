package br.com.axsilva.account.web

import br.com.axsilva.account.`input-boundary`.Transaction
import br.com.axsilva.account.web.dto.TransactionWebDTO
import br.com.axsilva.account.web.mapper.TransactionInputDtoMapper.Companion.mapperFrom
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController (
    private val transaction: Transaction? = null,
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping("/v1/account/transaction")
    fun transaction(@RequestBody transactionWebDTO: TransactionWebDTO): ResponseEntity<HttpStatus> {
        log.info("AccountController.transaction() = TransactionWebDTO:-> {}", transactionWebDTO)
        transaction?.transferFor(transactionWebDTO.mapperFrom())
        return ResponseEntity(HttpStatus.ACCEPTED)
    }
}