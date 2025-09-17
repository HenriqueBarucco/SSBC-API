package com.henriquebarucco.ssbc.external.easywhatsapp

import com.henriquebarucco.ssbc.external.easywhatsapp.dto.SendTextMessageRequest
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "easy-whatsapp-api-client", url = "\${easy-whatsapp.url}")
interface EasyWhatsAppClient {
    @PostMapping("\${easy-whatsapp.endpoints.text-message}")
    fun sendTextMessage(
        @RequestBody request: SendTextMessageRequest,
    ): ResponseEntity<*>
}
