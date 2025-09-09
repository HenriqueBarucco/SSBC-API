package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.impl

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.CreateSensorController
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.CreateSensorRequest
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.CreateSensorResponse
import com.henriquebarucco.ssbc.sensor.create.CreateSensorUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class CreateSensorControllerImpl(
    private val createSensorUseCase: CreateSensorUseCase,
) : CreateSensorController {
    override fun createSensor(request: CreateSensorRequest): ResponseEntity<CreateSensorResponse> {
        val command = request.toCommand()
        val output = this.createSensorUseCase.execute(command)

        return ResponseEntity.status(HttpStatus.CREATED).body(CreateSensorResponse.fromOutput(output))
    }
}
