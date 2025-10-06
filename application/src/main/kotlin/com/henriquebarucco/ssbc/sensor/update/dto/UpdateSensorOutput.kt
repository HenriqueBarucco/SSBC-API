package com.henriquebarucco.ssbc.sensor.update.dto

import com.henriquebarucco.ssbc.sensor.Sensor

data class UpdateSensorOutput(
    val id: String,
) {
    companion object {
        fun fromSensor(sensor: Sensor): UpdateSensorOutput =
            UpdateSensorOutput(
                sensor.id.value,
            )
    }
}
