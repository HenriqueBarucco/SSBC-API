package com.henriquebarucco.ssbc.sensor.dto

data class FetchSensorsDto(
    val pageSize: Int,
    val pageNumber: Int,
    val name: String?,
    val phoneNumber: String?,
)
