package com.henriquebarucco.ssbc.sensor.update.dto

import java.time.Instant

data class UpdateSensorCommand(
    val id: String,
    val name: String?,
    val phoneNumber: String?,
    var lastDetectedAt: Instant?,
)
