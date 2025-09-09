package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto

import com.henriquebarucco.ssbc.sensor.create.dto.CreateSensorOutput

data class CreateSensorResponse(
    val id: String,
) {
    companion object {
        fun fromOutput(output: CreateSensorOutput) =
            CreateSensorResponse(
                id = output.id,
            )
    }
}
