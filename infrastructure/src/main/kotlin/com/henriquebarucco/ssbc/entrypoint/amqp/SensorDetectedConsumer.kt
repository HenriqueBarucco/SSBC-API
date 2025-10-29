package com.henriquebarucco.ssbc.entrypoint.amqp

import com.henriquebarucco.ssbc.entrypoint.amqp.dto.SensorDetectedDto
import com.henriquebarucco.ssbc.sensor.detected.SensorDetectedUseCase
import com.henriquebarucco.ssbc.shared.exceptions.ResourceNotFoundException
import com.henriquebarucco.ssbc.shared.utils.Logger.Companion.getLogger
import kotlinx.serialization.json.Json
import org.slf4j.MDC
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class SensorDetectedConsumer(
    private val json: Json,
    private val sensorDetectedUseCase: SensorDetectedUseCase,
) {
    companion object {
        private const val MESSAGE_BODY = "MESSAGE_BODY"
    }

    private val logger = getLogger()

    @RabbitListener(
        queues = ["\${rabbitmq.queues.notify-sensor-detected.queue}"],
        containerFactory = "myRabbitListenerContainerFactory",
    )
    fun sensorDetectedMessage(message: ByteArray) {
        try {
            val payload = message.decodeToString()
            val messageBody = json.decodeFromString<SensorDetectedDto>(payload)
            MDC.put(MESSAGE_BODY, payload)

            this.logger.info("[SENSOR_DETECTED] Received message of sensor detected")
            this.sensorDetectedUseCase.execute(messageBody.toCommand())
            this.logger.info("[SENSOR_DETECTED] Successfully consumed message of sensor detected")
        } catch (ex: ResourceNotFoundException) {
            this.logger.warn("[SENSOR_DETECTED] Sensor not found", ex)
        } catch (ex: Exception) {
            this.logger.error("[SENSOR_DETECTED] Unable to process sensor detected message", ex)
        } finally {
            MDC.clear()
        }
    }
}
