package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto

import com.henriquebarucco.ssbc.sensor.update.dto.UpdateSensorOutput
import java.time.Instant

data class UpdateSensorResponse(
    val id: String,
    val name: String,
    val phone: String,
    var lastDetectedAt: Instant?,
) {
    companion object {
        fun fromOutput(updateSensorOutput: UpdateSensorOutput): UpdateSensorResponse =
            UpdateSensorResponse(
                id = updateSensorOutput.id,
                name = updateSensorOutput.name,
                phone = updateSensorOutput.phone,
                lastDetectedAt = updateSensorOutput.lastDetectedAt,
            )
    }
}
