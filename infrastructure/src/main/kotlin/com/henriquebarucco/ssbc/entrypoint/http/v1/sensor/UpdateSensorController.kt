package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.request.UpdateSensorRequest
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.response.UpdateSensorResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import io.swagger.v3.oas.annotations.parameters.RequestBody as OasRequestBody

@Tag(name = "Sensors", description = "Operações de gestão de sensores")
@RequestMapping("/v1/sensors")
interface UpdateSensorController {
    @PatchMapping("/{id}")
    @Operation(
        summary = "Atualiza parcialmente um sensor",
        description = "Atualiza dados do sensor informado e retorna o recurso atualizado",
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Sensor atualizado"),
            ApiResponse(responseCode = "400", description = "Dados inválidos"),
            ApiResponse(responseCode = "404", description = "Sensor não encontrado"),
        ],
    )
    fun updateSensor(
        @Parameter(description = "Identificador do sensor", example = "a1b2c3d4")
        @PathVariable id: String,
        @OasRequestBody(description = "Campos para atualização parcial do sensor")
        @RequestBody updateSensorRequest: UpdateSensorRequest,
    ): ResponseEntity<UpdateSensorResponse>
}
