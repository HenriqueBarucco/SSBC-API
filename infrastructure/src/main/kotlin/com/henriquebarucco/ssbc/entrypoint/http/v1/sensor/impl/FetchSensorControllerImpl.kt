package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.impl

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.FetchSensorController
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.FetchSensorRequest
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.FetchSensorResponse
import com.henriquebarucco.ssbc.sensor.fetch.FetchSensorUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RestController

@RestController
class FetchSensorControllerImpl(
    private val fetchSensorUseCase: FetchSensorUseCase,
) : FetchSensorController {
    override fun fetchSensors(
        @ModelAttribute fetchSensorRequest: FetchSensorRequest,
    ): ResponseEntity<FetchSensorResponse> {
        val fetchSensorQuery = fetchSensorRequest.toCommand()
        val result = fetchSensorUseCase.execute(fetchSensorQuery)
        return ResponseEntity.ok().body(FetchSensorResponse.fromOutput(result))
    }
}
