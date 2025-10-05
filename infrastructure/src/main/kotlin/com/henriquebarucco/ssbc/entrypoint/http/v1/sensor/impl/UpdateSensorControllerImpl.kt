package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.impl

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.UpdateSensorController
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.UpdateSensorRequest
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.UpdateSensorResponse
import com.henriquebarucco.ssbc.sensor.update.UpdateSensorUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UpdateSensorControllerImpl(
    private val updateSensorUseCase: UpdateSensorUseCase,
) : UpdateSensorController {
    override fun updateSensor(
        id: String,
        updateSensorRequest: UpdateSensorRequest,
    ): ResponseEntity<UpdateSensorResponse> {
        val command = updateSensorRequest.toCommand(id)
        val result = this.updateSensorUseCase.execute(command)
        return ResponseEntity.ok(UpdateSensorResponse.fromOutput(result))
    }
}
