package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.response.GetSensorByIdResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Tag(name = "Sensors", description = "Operações de gestão de sensores")
@RequestMapping("/v1/sensors")
interface GetSensorByIdController {
    @GetMapping("/{id}")
    @Operation(
        summary = "Busca sensor pelo ID",
        description = "Retorna as informações de um sensor a partir do seu identificador",
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Sensor encontrado"),
            ApiResponse(responseCode = "404", description = "Sensor não encontrado"),
        ],
    )
    fun getSensorById(
        @Parameter(description = "Identificador do sensor", example = "a1b2c3d4")
        @PathVariable id: String,
    ): ResponseEntity<GetSensorByIdResponse>
}
