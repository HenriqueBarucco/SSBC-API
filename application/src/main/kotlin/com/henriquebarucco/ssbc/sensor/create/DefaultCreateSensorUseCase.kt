package com.henriquebarucco.ssbc.sensor.create

import com.henriquebarucco.ssbc.sensor.Sensor
import com.henriquebarucco.ssbc.sensor.create.dto.CreateSensorCommand
import com.henriquebarucco.ssbc.sensor.create.dto.CreateSensorOutput

class DefaultCreateSensorUseCase : CreateSensorUseCase() {
    override fun execute(input: CreateSensorCommand): CreateSensorOutput {
        val (name, phoneNumber) = input

        val sensor = Sensor.new(name, phoneNumber)

        return CreateSensorOutput(sensor)
    }
}
