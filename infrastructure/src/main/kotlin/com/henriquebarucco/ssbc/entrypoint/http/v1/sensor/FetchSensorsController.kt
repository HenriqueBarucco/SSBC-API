package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.request.FetchSensorRequest
import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.response.FetchSensorsResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/v1/sensors")
interface FetchSensorsController {
    @GetMapping
    @Operation(
        summary = "Lista sensores com paginação e filtros",
        description = "Retorna uma lista paginada de sensores",
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
            ApiResponse(responseCode = "400", description = "Parâmetros de busca inválidos"),
        ],
    )
    fun fetchSensors(
        @Validated fetchSensorRequest: FetchSensorRequest,
    ): ResponseEntity<FetchSensorsResponse>
}
