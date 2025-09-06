package com.henriquebarucco.ssbc.shared.exceptions

class ResourceNotFoundException(
    override val message: String,
    override val cause: Throwable? = null,
) : RuntimeException(message, cause)
