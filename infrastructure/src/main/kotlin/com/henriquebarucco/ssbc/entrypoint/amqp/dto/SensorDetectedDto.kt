package com.henriquebarucco.ssbc.entrypoint.amqp.dto

import com.henriquebarucco.ssbc.sensor.detected.dto.SensorDetectedCommand
import kotlinx.serialization.Serializable

@Serializable
data class SensorDetectedDto(
    val id: String,
) {
    fun toCommand() =
        SensorDetectedCommand(
            sensorId = id,
            base64 = null,
        )
}
