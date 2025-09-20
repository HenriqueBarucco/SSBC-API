package com.henriquebarucco.ssbc.sensor

data class PaginatedOutput<T>(
    val content: List<T>,
    val totalElements: Long,
    val totalPages: Int,
)