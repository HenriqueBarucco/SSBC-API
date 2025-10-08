package com.henriquebarucco.ssbc.sensor

import com.henriquebarucco.ssbc.sensor.vo.Configuration
import com.henriquebarucco.ssbc.sensor.vo.Phone
import com.henriquebarucco.ssbc.shared.events.SensorDetectedDomainEvent
import com.henriquebarucco.ssbc.shared.events.SensorImageDomainEvent
import com.henriquebarucco.ssbc.shared.utils.Domain
import java.time.Instant

class Sensor(
    val id: SensorId,
    var name: String,
    var phone: Phone,
    var base64: String?,
    var lastDetectedAt: Instant?,
    var configuration: Configuration,
) : Domain() {
    companion object {
        fun new(
            name: String,
            phone: String,
        ) = Sensor(
            id = SensorId.unique(),
            name = name,
            phone = Phone(phone),
            base64 = null,
            lastDetectedAt = null,
            configuration = Configuration(60),
        )

        fun with(
            id: String,
            name: String,
            phoneNumber: String,
            base64: String?,
            lastDetectedAt: Instant?,
            delayToNotify: Long,
        ): Sensor =
            Sensor(
                id = SensorId.with(id),
                name = name,
                phone = Phone(phoneNumber),
                base64 = base64,
                lastDetectedAt = lastDetectedAt,
                configuration = Configuration(delayToNotify),
            )
    }

    fun detected(base64: String?) {
        val now = Instant.now()

        if (shouldRegisterEvent(now)) {
            this.lastDetectedAt = now
            registerEvent(SensorDetectedDomainEvent(this.id.value))

            if (base64 != null) {
                this.base64 = base64
                registerEvent(SensorImageDomainEvent(this.id.value))
            }
        }
    }

    fun update(
        name: String?,
        phoneNumber: String?,
        delayToNotify: Long?,
    ) {
        name?.let { this.name = it }
        phoneNumber?.let { this.phone = Phone(it) }
        delayToNotify?.let { this.configuration = Configuration(it) }
    }

    private fun shouldRegisterEvent(now: Instant) =
        this.lastDetectedAt == null || now.isAfter(this.lastDetectedAt!!.plusSeconds(this.configuration.delayToNotify))
}
