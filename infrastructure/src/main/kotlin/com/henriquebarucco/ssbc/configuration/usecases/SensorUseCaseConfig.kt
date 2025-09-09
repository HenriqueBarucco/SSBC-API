package com.henriquebarucco.ssbc.configuration.usecases

import com.henriquebarucco.ssbc.sensor.SensorGateway
import com.henriquebarucco.ssbc.sensor.create.CreateSensorUseCase
import com.henriquebarucco.ssbc.sensor.create.DefaultCreateSensorUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SensorUseCaseConfig(
    private val sensorGateway: SensorGateway,
) {
    @Bean
    fun createSensorUseCase(): CreateSensorUseCase = DefaultCreateSensorUseCase(sensorGateway)
}
