package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto

import com.henriquebarucco.ssbc.sensor.get.dto.GetSensorByIdOutput
import java.time.Instant

class GetSensorByIdResponse(
    val id: String,
    val name: String,
    val phone: String,
    var lastDetectedAt: Instant?,
) {
    companion object {
        fun fromOutput(getSensorByIdOutput: GetSensorByIdOutput): GetSensorByIdResponse =
            GetSensorByIdResponse(
                id = getSensorByIdOutput.id,
                name = getSensorByIdOutput.name,
                phone = getSensorByIdOutput.phone,
                lastDetectedAt = getSensorByIdOutput.lastDetectedAt,
            )
    }
}
