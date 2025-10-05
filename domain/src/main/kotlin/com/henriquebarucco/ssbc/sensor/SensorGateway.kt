package com.henriquebarucco.ssbc.sensor

import com.henriquebarucco.ssbc.sensor.dto.FetchSensorsDto
import com.henriquebarucco.ssbc.sensor.dto.SensorPageDto

interface SensorGateway {
    fun save(sensor: Sensor): Sensor

    fun ofId(sensorId: SensorId): Sensor?

    fun fetch(fetchSensorsDto: FetchSensorsDto): SensorPageDto

    fun update(sensor: Sensor): Sensor
}
