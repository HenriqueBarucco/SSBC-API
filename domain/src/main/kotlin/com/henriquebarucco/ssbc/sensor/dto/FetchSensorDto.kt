package com.henriquebarucco.ssbc.sensor.dto

data class FetchSensorDto(
    val pageSize: Int,
    val pageNumber: Int,
    val name: String?,
    val phoneNumber: String?,
)
