package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.impl

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.FetchSensorsController
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.request.FetchSensorRequest
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.response.FetchSensorsResponse
import com.henriquebarucco.ssbc.sensor.fetch.FetchSensorUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RestController

@RestController
class FetchSensorsControllerImpl(
    private val fetchSensorUseCase: FetchSensorUseCase,
) : FetchSensorsController {
    override fun fetchSensors(
        @ModelAttribute fetchSensorRequest: FetchSensorRequest,
    ): ResponseEntity<FetchSensorsResponse> {
        val command = fetchSensorRequest.toCommand()
        val result = this.fetchSensorUseCase.execute(command)
        return ResponseEntity.ok().body(FetchSensorsResponse.fromOutput(result))
    }
}
