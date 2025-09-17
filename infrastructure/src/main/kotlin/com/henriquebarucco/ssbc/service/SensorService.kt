package com.henriquebarucco.ssbc.service

import com.henriquebarucco.ssbc.database.mongodb.SensorMongodbRepository
import com.henriquebarucco.ssbc.database.mongodb.document.toDocument
import com.henriquebarucco.ssbc.event.DomainEventPublisher
import com.henriquebarucco.ssbc.sensor.Sensor
import com.henriquebarucco.ssbc.sensor.SensorGateway
import com.henriquebarucco.ssbc.sensor.SensorId
import org.springframework.stereotype.Service

@Service
class SensorService(
    private val sensorMongodbRepository: SensorMongodbRepository,
    private val eventPublisher: DomainEventPublisher,
) : SensorGateway {
    override fun save(sensor: Sensor): Sensor {
        val sensorDocument = sensor.toDocument()
        this.sensorMongodbRepository.save(sensorDocument)

        sensor.events.forEach { event ->
            eventPublisher.publish(event)
        }
        sensor.clearEvents()

        return sensor
    }

    override fun ofId(sensorId: SensorId): Sensor? {
        val sensorDocument = this.sensorMongodbRepository.findById(sensorId.value).orElse(null)
        return sensorDocument?.toDomain()
    }
}
