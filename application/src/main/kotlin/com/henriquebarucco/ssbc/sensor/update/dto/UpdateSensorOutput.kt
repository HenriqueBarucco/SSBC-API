package com.henriquebarucco.ssbc.sensor.update.dto

import com.henriquebarucco.ssbc.sensor.Sensor
import java.time.Instant

data class UpdateSensorOutput(
    val id: String,
    val name: String,
    val phone: String,
    var lastDetectedAt: Instant?,
) {
    companion object {
        fun fromSensor(sensor: Sensor): UpdateSensorOutput =
            UpdateSensorOutput(
                sensor.id.value,
                sensor.name,
                sensor.phone.number,
                sensor.lastDetectedAt,
            )
    }
}
