package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto

import com.henriquebarucco.ssbc.sensor.update.dto.UpdateSensorCommand
import java.time.Instant

data class UpdateSensorRequest(
    val name: String?,
    val phoneNumber: String?,
    var lastDetectedAt: Instant?,
) {
    fun toCommand(id: String): UpdateSensorCommand =
        UpdateSensorCommand(
            id = id,
            name = this.name,
            phoneNumber = this.phoneNumber,
            lastDetectedAt = this.lastDetectedAt,
        )
}
