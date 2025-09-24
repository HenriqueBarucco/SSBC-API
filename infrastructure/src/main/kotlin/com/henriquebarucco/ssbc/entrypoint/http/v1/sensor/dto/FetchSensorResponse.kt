package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto

import com.henriquebarucco.ssbc.sensor.Sensor
import com.henriquebarucco.ssbc.shared.PaginatedOutput

data class FetchSensorResponse(
    val content: List<Sensor>?,
    val totalElements: Long,
    val totalPages: Int,
) {
    companion object {
        fun fromOutput(output: PaginatedOutput<Sensor>): FetchSensorResponse =
            FetchSensorResponse(
                content = output.content,
                totalElements = output.totalElements,
                totalPages = output.totalPages,
            )
    }
}
