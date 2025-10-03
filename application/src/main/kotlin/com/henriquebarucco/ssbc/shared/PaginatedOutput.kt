package com.henriquebarucco.ssbc.shared

data class PaginatedOutput<T>(
    val content: List<T>,
    val totalElements: Long,
    val totalPages: Int,
)
