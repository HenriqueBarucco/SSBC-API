package com.henriquebarucco.ssbc.sensor.get.dto

data class FetchSensorCommand(
    val pageSize: Int,
    val pageNumber: Int,
    val name: String?,
    val phoneNumber: String?,
)
