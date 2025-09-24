package com.henriquebarucco.ssbc.sensor.get

import com.henriquebarucco.ssbc.sensor.SensorGateway
import com.henriquebarucco.ssbc.sensor.SensorId
import com.henriquebarucco.ssbc.sensor.get.dto.GetSensorByIdOutput
import com.henriquebarucco.ssbc.shared.exceptions.ResourceNotFoundException

class DefaultGetSensorByIdUseCase(
    private val sensorGateway: SensorGateway,
) : GetSensorByIdUseCase() {
    override fun execute(input: String): GetSensorByIdOutput {
        val result =
            this.sensorGateway.ofId(SensorId.with(input))
                ?: throw ResourceNotFoundException("Sensor with id $input not found")
        return GetSensorByIdOutput.fromSensor(sensor = result)
    }
}
