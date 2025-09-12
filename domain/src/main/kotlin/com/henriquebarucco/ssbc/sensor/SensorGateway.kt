package com.henriquebarucco.ssbc.sensor

interface SensorGateway {
    fun save(sensor: Sensor): Sensor

    fun ofId(sensorId: SensorId): Sensor?
}
