package com.henriquebarucco.ssbc.event.handler

import com.henriquebarucco.ssbc.database.mongodb.SensorMongodbRepository
import com.henriquebarucco.ssbc.external.easywhatsapp.EasyWhatsAppClient
import com.henriquebarucco.ssbc.external.easywhatsapp.dto.SendTextMessageRequest
import com.henriquebarucco.ssbc.shared.events.SensorDetectedDomainEvent
import com.henriquebarucco.ssbc.utils.Logger.Companion.getLogger
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class SensorDetectedEventHandler(
    private val sensorMongodbRepository: SensorMongodbRepository,
    private val easyWhatsAppClient: EasyWhatsAppClient,
) {
    private val logger = getLogger()

    @EventListener
    fun handle(event: SensorDetectedDomainEvent) {
        this.logger.info("[SENSOR_DETECTED_EVENT] Sensor detected event received: ${event.sensorId}")

        val sensor = this.sensorMongodbRepository.findById(event.sensorId).get()

        this.logger.info("[SENSOR_DETECTED_EVENT] Sending WhatsApp message to ${sensor.phoneNumber}")

        this.easyWhatsAppClient.sendTextMessage(
            SendTextMessageRequest(
                token = "token-xx",
                phone = sensor.phoneNumber,
                message = "O Sensor ${sensor.name} detectou movimento!",
            ),
        )

        this.logger.info("[SENSOR_DETECTED_EVENT] WhatsApp message sent to ${sensor.phoneNumber}")
    }
}
