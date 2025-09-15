package com.henriquebarucco.ssbc.sensor

import com.henriquebarucco.ssbc.sensor.dto.GetSensorDto
import com.henriquebarucco.ssbc.sensor.dto.SensorPageDto

interface SensorGateway {
    fun save(sensor: Sensor): Sensor

    fun ofId(sensorId: SensorId): Sensor?

    fun getSensor(getSensorDto: GetSensorDto): SensorPageDto?
}
