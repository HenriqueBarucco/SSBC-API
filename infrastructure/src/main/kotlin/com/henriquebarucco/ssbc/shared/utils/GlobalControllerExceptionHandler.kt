package com.henriquebarucco.ssbc.shared.utils

import com.henriquebarucco.ssbc.shared.exceptions.InvalidStringValueException
import com.henriquebarucco.ssbc.shared.exceptions.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

data class ExceptionResponse(
    val status: HttpStatus,
    val message: String,
)

@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidStringValueException::class)
    fun handleInvalidString(exception: Exception): ResponseEntity<ExceptionResponse> =
        ResponseEntity.badRequest().body(
            ExceptionResponse(
                status = HttpStatus.BAD_REQUEST,
                message = exception.localizedMessage,
            ),
        )

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFound(exception: Exception): ResponseEntity<ExceptionResponse> =
        ResponseEntity.badRequest().body(
            ExceptionResponse(
                status = HttpStatus.NOT_FOUND,
                message = exception.localizedMessage,
            ),
        )
}
