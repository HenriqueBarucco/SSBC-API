package com.henriquebarucco.ssbc.event.handler

import com.henriquebarucco.ssbc.database.mongodb.SensorMongodbRepository
import com.henriquebarucco.ssbc.external.NotificationSender
import com.henriquebarucco.ssbc.shared.events.SensorDetectedDomainEvent
import com.henriquebarucco.ssbc.utils.Logger.Companion.getLogger
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.util.Base64

@Component
class SensorImageEventHandler(
    private val sensorMongodbRepository: SensorMongodbRepository,
    private val notificationSenders: List<NotificationSender>,
) {
    private val logger = getLogger()

    @EventListener
    fun handle(event: SensorDetectedDomainEvent) {
        this.logger.info("[SENSOR_IMAGE_EVENT] Sensor image event received: ${event.sensorId}")

        val sensor = this.sensorMongodbRepository.findById(event.sensorId).get()

        val photoBytes: ByteArray = Base64.getDecoder().decode(sensor.base64)

        this.notificationSenders.map {
            it.send(
                to = sensor.phoneNumber,
                message = null,
                photo = photoBytes,
            )
        }
    }
}
