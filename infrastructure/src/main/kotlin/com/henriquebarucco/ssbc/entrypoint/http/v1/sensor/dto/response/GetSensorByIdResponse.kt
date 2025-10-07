package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.response

import com.henriquebarucco.ssbc.sensor.get.dto.GetSensorByIdOutput
import java.time.Instant

data class GetSensorByIdResponse(
    val id: String,
    val name: String,
    val phone: String,
    var lastDetectedAt: Instant?,
) {
    companion object {
        fun fromOutput(output: GetSensorByIdOutput): GetSensorByIdResponse =
            GetSensorByIdResponse(
                id = output.id,
                name = output.name,
                phone = output.phone,
                lastDetectedAt = output.lastDetectedAt,
            )
    }
}
