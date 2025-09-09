package com.henriquebarucco.ssbc.sensor

import com.henriquebarucco.ssbc.sensor.vo.Phone
import com.henriquebarucco.ssbc.shared.events.SensorDetectedDomainEvent
import com.henriquebarucco.ssbc.shared.utils.Domain
import java.time.Instant

class Sensor(
    val id: SensorId,
    val name: String,
    val phone: Phone,
    var lastDetectedAt: Instant?,
) : Domain() {
    companion object {
        fun new(
            name: String,
            phone: String,
        ) = Sensor(
            id = SensorId.unique(),
            name = name,
            phone = Phone(phone),
            lastDetectedAt = null,
        )

        fun with(
            id: String,
            name: String,
            phoneNumber: String,
            lastDetectedAt: Instant?,
        ): Sensor =
            Sensor(
                id = SensorId.with(id),
                name = name,
                phone = Phone(phoneNumber),
                lastDetectedAt = lastDetectedAt,
            )
    }

    fun detected() {
        this.lastDetectedAt = Instant.now()
        registerEvent(SensorDetectedDomainEvent(this.id.value))
    }
}
