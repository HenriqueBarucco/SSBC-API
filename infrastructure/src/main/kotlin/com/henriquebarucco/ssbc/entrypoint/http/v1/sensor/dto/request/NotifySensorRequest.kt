package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.request

import com.henriquebarucco.ssbc.sensor.detected.dto.SensorDetectedCommand
import jakarta.validation.constraints.NotBlank

data class NotifySensorRequest(
    @field:NotBlank
    val base64: String?,
) {
    fun toCommand(sensorId: String) =
        SensorDetectedCommand(
            sensorId = sensorId,
            base64 = base64,
        )
}
