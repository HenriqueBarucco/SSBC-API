package com.henriquebarucco.ssbc.sensor.fetch.dto

data class FetchSensorsCommand(
    val pageSize: Int,
    val pageNumber: Int,
    val name: String?,
    val phoneNumber: String?,
)
