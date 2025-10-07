package com.henriquebarucco.ssbc.database.mongodb.document

import com.henriquebarucco.ssbc.sensor.Sensor
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document("sensors")
data class SensorDocument(
    @Id
    val id: String,
    val name: String,
    val phoneNumber: String,
    val lastDetectedAt: Instant?,
    val delayToNotify: Long,
) {
    fun toDomain() = Sensor.with(id, name, phoneNumber, lastDetectedAt, delayToNotify)
}

fun Sensor.toDocument() =
    SensorDocument(
        id = id.value,
        name = name,
        phoneNumber = phone.number,
        lastDetectedAt = lastDetectedAt,
        delayToNotify = configuration.delayToNotify,
    )
