package com.henriquebarucco.ssbc.sensor.dto

import com.henriquebarucco.ssbc.sensor.Sensor

data class SensorPageDto(
    var content: List<Sensor>,
    val totalElements: Long,
    val totalPages: Int,
)