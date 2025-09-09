package com.henriquebarucco.ssbc.shared.events

import com.henriquebarucco.ssbc.event.DomainEvent
import java.time.Instant
import java.util.UUID

data class SensorDetectedDomainEvent(
    val sensorId: String,
    override val id: UUID = UUID.randomUUID(),
    override val occurredAt: Instant = Instant.now(),
) : DomainEvent
