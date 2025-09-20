package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto

import com.henriquebarucco.ssbc.sensor.PaginatedOutput
import com.henriquebarucco.ssbc.sensor.Sensor


data class GetSensorResponse(
    val content: List<Sensor>?,
    val totalElements: Long,
    val totalPages: Int,
) {
    companion object {
        fun fromOutput(output: PaginatedOutput<Sensor>): GetSensorResponse =
            GetSensorResponse(
                content = output.content,
                totalElements = output.totalElements,
                totalPages = output.totalPages,
            )

    }
}
