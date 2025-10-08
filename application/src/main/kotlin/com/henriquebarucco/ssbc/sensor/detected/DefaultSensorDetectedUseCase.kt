package com.henriquebarucco.ssbc.sensor.detected

import com.henriquebarucco.ssbc.sensor.SensorGateway
import com.henriquebarucco.ssbc.sensor.SensorId
import com.henriquebarucco.ssbc.sensor.detected.dto.SensorDetectedCommand
import com.henriquebarucco.ssbc.shared.exceptions.ResourceNotFoundException
import com.henriquebarucco.ssbc.utils.Logger.Companion.getLogger

class DefaultSensorDetectedUseCase(
    private val sensorGateway: SensorGateway,
) : SensorDetectedUseCase() {
    private val logger = getLogger()

    override fun execute(input: SensorDetectedCommand) {
        val (sensorId, base64) = input

        this.logger.info("[SENSOR_DETECTED] Starting sensor detected $sensorId")

        val sensor =
            this.sensorGateway.ofId(SensorId.with(sensorId))
                ?: throw ResourceNotFoundException("Sensor with id $sensorId not found")

        sensor.detected(base64)
        this.sensorGateway.save(sensor)

        this.logger.info("[SENSOR_DETECTED] Sensor detected finished $sensorId")
    }
}
