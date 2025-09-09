package com.henriquebarucco.ssbc.event.handler

import com.henriquebarucco.ssbc.shared.events.SensorDetectedDomainEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class SensorDetectedEventHandler {
    @EventListener
    fun handle(event: SensorDetectedDomainEvent) {
        println("Sensor detected: ${event.sensorId} at ${event.occurredAt}")
    }
}
