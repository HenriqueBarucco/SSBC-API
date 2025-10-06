package com.henriquebarucco.ssbc.sensor.update.dto

data class UpdateSensorCommand(
    val id: String,
    val name: String?,
    val phoneNumber: String?,
)
