package com.henriquebarucco.ssbc.sensor.update

import com.henriquebarucco.ssbc.sensor.SensorGateway
import com.henriquebarucco.ssbc.sensor.SensorId
import com.henriquebarucco.ssbc.sensor.update.dto.UpdateSensorCommand
import com.henriquebarucco.ssbc.sensor.update.dto.UpdateSensorOutput
import com.henriquebarucco.ssbc.shared.exceptions.ResourceNotFoundException

class DefaultUpdateSensorUseCase(
    private val sensorGateway: SensorGateway,
) : UpdateSensorUseCase() {
    override fun execute(input: UpdateSensorCommand): UpdateSensorOutput {
        val (id, name, phoneNumber) = input

        val sensor =
            this.sensorGateway.ofId(SensorId.with(id))
                ?: throw ResourceNotFoundException("Sensor with id $id not found")

        sensor.update(name, phoneNumber)

        val result = this.sensorGateway.save(sensor)
        return UpdateSensorOutput.fromSensor(result)
    }
}
