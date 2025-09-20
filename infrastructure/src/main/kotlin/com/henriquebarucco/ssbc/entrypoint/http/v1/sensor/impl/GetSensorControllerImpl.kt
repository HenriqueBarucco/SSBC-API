package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.impl

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.GetSensorController
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.GetSensorRequest
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.GetSensorResponse
import com.henriquebarucco.ssbc.sensor.get.GetSensorUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RestController

@RestController
class GetSensorControllerImpl(
    private val getSensorUseCase: GetSensorUseCase
) : GetSensorController {
    override fun getSensors(@ModelAttribute getSensorRequest: GetSensorRequest): ResponseEntity<GetSensorResponse> {
        val getSensorQuery = getSensorRequest.toCommand()
        val result = getSensorUseCase.execute(getSensorQuery)
        return ResponseEntity.ok().body(GetSensorResponse.fromOutput(result))
    }
}