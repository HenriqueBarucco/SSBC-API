package com.henriquebarucco.ssbc.service

import com.henriquebarucco.ssbc.database.mongodb.SensorMongodbRepository
import com.henriquebarucco.ssbc.database.mongodb.document.toDocument
import com.henriquebarucco.ssbc.sensor.Sensor
import com.henriquebarucco.ssbc.sensor.SensorGateway
import org.springframework.stereotype.Service

@Service
class SensorService(
    private val sensorMongodbRepository: SensorMongodbRepository,
) : SensorGateway {
    override fun save(sensor: Sensor): Sensor {
        val sensorDocument = sensor.toDocument()
        this.sensorMongodbRepository.save(sensorDocument)

        return sensor
    }
}
