package com.henriquebarucco.ssbc.event.handler

import com.henriquebarucco.ssbc.database.mongodb.SensorMongodbRepository
import com.henriquebarucco.ssbc.external.NotificationSender
import com.henriquebarucco.ssbc.external.lmstudio.LmStudioService
import com.henriquebarucco.ssbc.shared.events.SensorImageAnalyzerDomainEvent
import com.henriquebarucco.ssbc.utils.Logger.Companion.getLogger
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.Base64

@Component
class SensorImageAnalyzerEventHandler(
    private val sensorMongodbRepository: SensorMongodbRepository,
    private val notificationSenders: List<NotificationSender>,
    private val lmStudioService: LmStudioService,
) {
    private val logger = getLogger()

    @Async
    @EventListener
    fun handle(event: SensorImageAnalyzerDomainEvent) {
        this.logger.info("[SENSOR_IMAGE_ANALYZER_EVENT] Sensor image analyzer event received: ${event.sensorId}")

        val sensor = this.sensorMongodbRepository.findById(event.sensorId).get()

        val photoBytes: ByteArray = Base64.getDecoder().decode(sensor.base64)

        val response = this.lmStudioService.performImageExtraction(photoBytes)

        this.notificationSenders.map {
            it.send(
                to = sensor.phoneNumber,
                message = response,
            )
        }
    }
}
