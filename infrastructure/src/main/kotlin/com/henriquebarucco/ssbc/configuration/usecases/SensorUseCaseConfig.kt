package com.henriquebarucco.ssbc.configuration.usecases

import com.henriquebarucco.ssbc.sensor.SensorGateway
import com.henriquebarucco.ssbc.sensor.create.CreateSensorUseCase
import com.henriquebarucco.ssbc.sensor.create.DefaultCreateSensorUseCase
import com.henriquebarucco.ssbc.sensor.detected.DefaultSensorDetectedUseCase
import com.henriquebarucco.ssbc.sensor.detected.SensorDetectedUseCase
import com.henriquebarucco.ssbc.sensor.get.DefaultGetSensorUseCase
import com.henriquebarucco.ssbc.sensor.get.GetSensorUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SensorUseCaseConfig(
    private val sensorGateway: SensorGateway,
) {
    @Bean
    fun createSensorUseCase(): CreateSensorUseCase = DefaultCreateSensorUseCase(sensorGateway)

    @Bean
    fun sensorDetectedUseCase(): SensorDetectedUseCase = DefaultSensorDetectedUseCase(sensorGateway)

    @Bean
    fun getSensorUseCase(): GetSensorUseCase = DefaultGetSensorUseCase(sensorGateway)
}
