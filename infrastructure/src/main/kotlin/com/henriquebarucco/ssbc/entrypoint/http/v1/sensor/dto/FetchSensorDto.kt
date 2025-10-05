package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto

import com.henriquebarucco.ssbc.sensor.Sensor
import com.henriquebarucco.ssbc.sensor.SensorId
import com.henriquebarucco.ssbc.sensor.vo.Phone
import java.time.Instant

data class FetchSensorDto(
    val id: SensorId,
    val name: String,
    val phone: Phone,
    var lastDetectedAt: Instant?,
) {
    companion object {
        fun fromDomain(sensor: Sensor): FetchSensorDto =
            FetchSensorDto(
                id = sensor.id,
                name = sensor.name,
                phone = sensor.phone,
                lastDetectedAt = sensor.lastDetectedAt,
            )
    }
}
