package com.henriquebarucco.ssbc.service

import com.henriquebarucco.ssbc.database.mongodb.SensorMongodbRepository
import com.henriquebarucco.ssbc.database.mongodb.document.SensorDocument
import com.henriquebarucco.ssbc.database.mongodb.document.toDocument
import com.henriquebarucco.ssbc.event.DomainEventPublisher
import com.henriquebarucco.ssbc.sensor.Sensor
import com.henriquebarucco.ssbc.sensor.SensorGateway
import com.henriquebarucco.ssbc.sensor.SensorId
import com.henriquebarucco.ssbc.sensor.dto.GetSensorDto
import com.henriquebarucco.ssbc.sensor.dto.SensorPageDto
import com.henriquebarucco.ssbc.service.templates.SensorQueryTemplatesBuilder
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Service

@Service
class SensorService(
    private val sensorMongodbRepository: SensorMongodbRepository,
    private val eventPublisher: DomainEventPublisher,
    private val mongoTemplate: MongoTemplate
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

    override fun getSensor(getSensorDto: GetSensorDto): SensorPageDto {
        val sensorDocumentPage = this.executeQuery(getSensorDto)
        val sensors = sensorDocumentPage.content.map { it.toDomain() }
        return SensorPageDto(
            content = sensors,
            totalElements = sensorDocumentPage.totalElements,
            totalPages = sensorDocumentPage.totalPages,
        )
    }


    private fun executeQuery(getSensorDto: GetSensorDto): Page<SensorDocument> {
        val builder = SensorQueryTemplatesBuilder(getSensorDto)
        val (pageSize, pageNumber) = getSensorDto
        val pageable = PageRequest.of(pageNumber, pageSize)

        builder.whereName()
        builder.wherePhoneNumber()

        val query = builder.compileQuery(pageable)
        val results = mongoTemplate.find(query, SensorDocument::class.java)
        val total = mongoTemplate.count(query, SensorDocument::class.java)
        return PageImpl(results, pageable, total)
    }

}
