package com.henriquebarucco.ssbc.entrypoint.http.v1.sensor

import com.henriquebarucco.ssbc.entrypoint.http.v1.sensor.dto.request.NotifySensorRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import io.swagger.v3.oas.annotations.parameters.RequestBody as OasRequestBody

@Tag(name = "Sensors", description = "Operações de gestão de sensores")
@RequestMapping("/v1/sensors")
interface NotifySensorController {
    @PostMapping("/{id}/notify")
    @Operation(
        summary = "Notificar sensor pelo ID",
        description = "Notifica o sensor com os dados fornecidos no corpo da requisição",
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "204", description = "Notificação enviada com sucesso"),
            ApiResponse(responseCode = "400", description = "Requisição inválida"),
        ],
    )
    fun notifySensor(
        @OasRequestBody(description = "Dados da imagem", required = true)
        @RequestBody
        @Validated request: NotifySensorRequest,
        @PathVariable id: String,
    ): ResponseEntity<Void>
}
