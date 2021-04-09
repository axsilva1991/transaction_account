package br.com.axsilva.account.web

import br.com.axsilva.account.`input-boundary`.exception.BadInputValuesException
import br.com.axsilva.account.web.handler.dto.ErrorMessageWebDTO
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.lang.Exception

@ControllerAdvice
class ControllerAdvisor {
    @ExceptionHandler(value = [BadInputValuesException::class])
    fun notFoundException(
        ex: BadInputValuesException,
        request: WebRequest?
    ): ResponseEntity<ErrorMessageWebDTO?>? {
        return ResponseEntity(ErrorMessageWebDTO(ex.message.toString()), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [Exception::class])
    fun internalServerErrorException(
        ex: BadInputValuesException,
        request: WebRequest?
    ): ResponseEntity<ErrorMessageWebDTO?>? {
        return ResponseEntity(ErrorMessageWebDTO(ex.message.toString()), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
