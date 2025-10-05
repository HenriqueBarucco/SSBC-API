package com.henriquebarucco.ssbc.sensor.update

import com.henriquebarucco.ssbc.sensor.Sensor
import com.henriquebarucco.ssbc.sensor.SensorGateway
import com.henriquebarucco.ssbc.sensor.SensorId
import com.henriquebarucco.ssbc.sensor.update.dto.UpdateSensorCommand
import com.henriquebarucco.ssbc.sensor.update.dto.UpdateSensorOutput
import com.henriquebarucco.ssbc.shared.exceptions.ResourceNotFoundException

class DefaultUpdateSensorUseCase(
    private val sensorGateway: SensorGateway,
) : UpdateSensorUseCase() {
    override fun execute(input: UpdateSensorCommand): UpdateSensorOutput {
        val sensor =
            this.sensorGateway.ofId(SensorId.with(input.id))
                ?: throw ResourceNotFoundException("Sensor with id $input not found")
        val sensorToSave =
            Sensor.with(
                id = input.id,
                name = input.name ?: sensor.name,
                phoneNumber = input.phoneNumber ?: sensor.phone.number,
                lastDetectedAt = input.lastDetectedAt,
            )
        val result = sensorGateway.save(sensorToSave)
        return UpdateSensorOutput.fromSensor(result)
    }
}
