package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.request.UpdateSensorRequest
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.response.UpdateSensorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/v1/sensors")
interface UpdateSensorController {
    @PatchMapping("/{id}")
    fun updateSensor(
        @PathVariable id: String,
        @RequestBody updateSensorRequest: UpdateSensorRequest,
    ): ResponseEntity<UpdateSensorResponse>
}
