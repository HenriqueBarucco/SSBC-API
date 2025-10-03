package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.impl

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.GetSensorByIdController
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.GetSensorByIdResponse
import com.henriquebarucco.ssbc.sensor.get.GetSensorByIdUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class GetSensorByIdControllerImpl(
    private val getSensorBydIdUseCase: GetSensorByIdUseCase,
) : GetSensorByIdController {
    override fun getSensorById(id: String): ResponseEntity<GetSensorByIdResponse> {
        val fromOutput = GetSensorByIdResponse.fromOutput(getSensorBydIdUseCase.execute(id))
        return ResponseEntity.ok(fromOutput)
    }
}
