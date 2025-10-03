package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.GetSensorByIdResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/v1/sensors")
interface GetSensorByIdController {
    @GetMapping("/sensors/{id}")
    fun getSensorById(
        @PathVariable id: String,
    ): ResponseEntity<GetSensorByIdResponse>
}
