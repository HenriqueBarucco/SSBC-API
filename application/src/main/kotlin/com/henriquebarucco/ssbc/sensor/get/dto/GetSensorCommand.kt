package com.henriquebarucco.ssbc.sensor.get.dto

data class GetSensorCommand(
    val pageSize: Int,
    val pageNumber: Int,
    val name: String?,
    val phoneNumber: String?,
)