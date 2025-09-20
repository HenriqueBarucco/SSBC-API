package com.henriquebarucco.ssbc.sensor.get.dto

import com.henriquebarucco.ssbc.sensor.Sensor
import java.time.Instant


data class GetSensorByIdOutput(
    val id: String,
    val name: String,
    val phone: String,
    var lastDetectedAt: Instant?,

    ) {


    companion object {
        fun fromSensor(sensor: Sensor): GetSensorByIdOutput {
            return GetSensorByIdOutput(
                id = sensor.id.value,
                name = sensor.name,
                phone = sensor.phone.number,
                lastDetectedAt = sensor.lastDetectedAt,
            )
        }
    }


}