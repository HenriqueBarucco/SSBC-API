package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.response

import com.henriquebarucco.ssbc.sensor.Sensor
import com.henriquebarucco.ssbc.shared.PaginatedOutput

data class FetchSensorsResponse(
    val content: List<FetchSensorResponse>,
    val totalElements: Long,
    val totalPages: Int,
) {
    companion object {
        fun fromOutput(output: PaginatedOutput<Sensor>): FetchSensorsResponse =
            FetchSensorsResponse(
                content = output.content.map { it -> FetchSensorResponse.fromDomain(it) },
                totalElements = output.totalElements,
                totalPages = output.totalPages,
            )
    }
}

data class FetchSensorResponse(
    val id: String,
    val name: String,
    val phoneNumber: String,
    val lastDetectedAt: String?,
) {
    companion object {
        fun fromDomain(sensor: Sensor): FetchSensorResponse =
            FetchSensorResponse(
                id = sensor.id.value,
                name = sensor.name,
                phoneNumber = sensor.phone.number,
                lastDetectedAt = sensor.lastDetectedAt?.toString(),
            )
    }
}
