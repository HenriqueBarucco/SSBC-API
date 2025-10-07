package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.response

import com.henriquebarucco.ssbc.sensor.update.dto.UpdateSensorOutput

data class UpdateSensorResponse(
    val id: String,
) {
    companion object {
        fun fromOutput(output: UpdateSensorOutput): UpdateSensorResponse =
            UpdateSensorResponse(
                id = output.id,
            )
    }
}
