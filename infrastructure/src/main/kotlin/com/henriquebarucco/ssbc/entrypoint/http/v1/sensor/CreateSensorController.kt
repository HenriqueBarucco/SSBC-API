package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.request.CreateSensorRequest
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.response.CreateSensorResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import io.swagger.v3.oas.annotations.parameters.RequestBody as OasRequestBody

@Tag(name = "Sensors", description = "Operações de gestão de sensores")
@RequestMapping("/v1/sensors")
interface CreateSensorController {
    @PostMapping
    @Operation(
        summary = "Cria um novo sensor",
        description = "Cria e retorna o sensor recém cadastrado",
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "Sensor criado com sucesso"),
            ApiResponse(responseCode = "400", description = "Requisição inválida"),
        ],
    )
    fun createSensor(
        @OasRequestBody(description = "Dados para criação do sensor", required = true)
        @RequestBody
        @Validated request: CreateSensorRequest,
    ): ResponseEntity<CreateSensorResponse>
}
