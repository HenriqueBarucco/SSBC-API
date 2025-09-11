package com.henriquebarucco.ssbc.database.mongodb.document

import com.henriquebarucco.ssbc.sensor.Sensor
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("sensors")
data class SensorDocument(
    @Id
    val id: String,
    val name: String,
    val phoneNumber: String,
) {
    fun toDomain() = Sensor.with(id, name, phoneNumber)
}

fun Sensor.toDocument() =
    SensorDocument(
        id = id.value,
        name = name,
        phoneNumber = phone.number,
    )
