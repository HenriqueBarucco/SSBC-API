package com.henriquebarucco.ssbc.sensor.dto

data class GetSensorDto(
    val pageSize: Int,
    val pageNumber: Int,
    val name: String?,
    val phoneNumber: String?,
)