package com.henriquebarucco.ssbc.external.easywhatsapp

import com.henriquebarucco.ssbc.external.NotificationSender
import com.henriquebarucco.ssbc.external.easywhatsapp.dto.SendTextMessageRequest
import com.henriquebarucco.ssbc.utils.Logger.Companion.getLogger
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class WhatsAppMessageSender(
    private val easyWhatsAppClient: EasyWhatsAppClient,
    @Value("\${easy-whatsapp.token}") private val token: String,
) : NotificationSender {
    private val logger = getLogger()

    override fun send(
        to: String,
        message: String,
    ) {
        this.logger.info("[WHATSAPP_SENDER] Sending WhatsApp message to $to")

        this.easyWhatsAppClient.sendTextMessage(
            SendTextMessageRequest(
                token = token,
                phone = to,
                message = message,
            ),
        )

        this.logger.info("[WHATSAPP_SENDER] WhatsApp message sent to $to")
    }

    override fun send(
        to: String,
        message: String,
        photo: ByteArray,
    ) {
        TODO("Not yet implemented")
    }
}
