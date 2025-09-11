package com.henriquebarucco.ssbc.sensor.create.dto

import com.henriquebarucco.ssbc.sensor.Sensor

data class CreateSensorOutput(
    val id: String,
) {
    constructor(sensor: Sensor) : this(
        id = sensor.id.value,
    )
}
