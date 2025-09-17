package com.henriquebarucco.ssbc.event.handler

import com.henriquebarucco.ssbc.database.mongodb.SensorMongodbRepository
import com.henriquebarucco.ssbc.external.NotificationSender
import com.henriquebarucco.ssbc.shared.events.SensorDetectedDomainEvent
import com.henriquebarucco.ssbc.utils.Logger.Companion.getLogger
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class SensorDetectedEventHandler(
    private val sensorMongodbRepository: SensorMongodbRepository,
    private val notificationSenders: List<NotificationSender>,
) {
    private val logger = getLogger()

    @EventListener
    fun handle(event: SensorDetectedDomainEvent) {
        this.logger.info("[SENSOR_DETECTED_EVENT] Sensor detected event received: ${event.sensorId}")

        val sensor = this.sensorMongodbRepository.findById(event.sensorId).get()

        this.notificationSenders.map {
            it.send(
                to = sensor.phoneNumber,
                message = "O Sensor ${sensor.name} detectou movimento!",
            )
        }
    }
}
